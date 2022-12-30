package de.conciso.shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Hidden;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.junit5.JGivenExtension;
import com.tngtech.jgiven.junit5.ScenarioTest;

import java.util.Optional;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

@ExtendWith(JGivenExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ShopServiceTest extends ScenarioTest<ShopServiceTest.GivenStage, ShopServiceTest.WhenStage, ShopServiceTest.ThenStage> {

  @Test
  void should_create_person() {

    given().person("Georg", "Pietrek")
        .and().person_can_be_created();

    when().calling_createPerson();

    then().create_was_called_on_Personen()
        .and().created_person_is_returned();
  }

  @Test
  void should_add_address() {
    given().person(42, "Georg", "Pietrek")
        .and().address("Pariser Bogen 7", 44269, "Dortmund")
        .and().address_can_be_added();
    when().calling_addAddress();
    then().addAddress_was_called_on_Personen()
        .and().person_is_returned();
  }

  @Test
  void cannot_add_address_if_person_not_found() {
    given().person(42, "Georg", "Pietrek")
        .and().address("Pariser Bogen 7", 44269, "Dortmund")
        .and().address_cannot_be_added();
    when().calling_addAddress();
    then().addAddress_was_called_on_Personen()
        .and().no_person_is_returned();
  }

  protected static class GivenStage extends Stage<GivenStage> {

    @ProvidedScenarioState
    private Personen personen;

    @ProvidedScenarioState
    private Auftraege auftraege;

    @ProvidedScenarioState
    private ShopService sut;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Person person;

    @ProvidedScenarioState
    private Address address;

    @BeforeStage
    void build() {
      personen = mock(Personen.class);
      auftraege = mock(Auftraege.class);
      sut = new ShopService(personen, auftraege);
    }

    public GivenStage person(@Hidden int id, String vorname, String name) {
      person = Person.builder()
          .id(id)
          .vorname(vorname)
          .name(name)
          .build();
      return self();
    }

    public GivenStage person(String vorname, String name) {
      person = Person.builder()
          .vorname(vorname)
          .name(name)
          .build();
      return self();
    }

    public GivenStage address(String strasse, int plz, String ort) {
      address = Address.builder()
          .strasse(strasse)
          .plz(plz)
          .ort(ort)
          .build();
      return self();
    }

    public GivenStage person_can_be_created() {
      Mockito.when(personen.create(any(Person.class))).thenReturn(person);
      return self();
    }

    public GivenStage person_not_found() {
      Mockito.when(personen.findById(anyInt())).thenReturn(Optional.empty());
      return self();
    }

    public GivenStage person_can_be_found() {
      Mockito.when(personen.findById(anyInt())).thenReturn(Optional.of(person));
      return self();
    }

    public GivenStage address_can_be_added() {
      Mockito.when(personen.addAddress(anyInt(), any(Address.class))).thenReturn(Optional.of(person));
      return self();
    }

    public GivenStage address_cannot_be_added() {
      Mockito.when(personen.addAddress(anyInt(), any(Address.class))).thenReturn(Optional.empty());
      return self();
    }
  }

  protected static class WhenStage extends Stage<WhenStage> {

    @ExpectedScenarioState
    private ShopService sut;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Person person;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Person createdPerson;

    @ExpectedScenarioState
    Address address;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Optional<Person> result;

    public WhenStage calling_createPerson() {
      createdPerson = sut.createPerson(person);
      return self();
    }

    public WhenStage calling_addAddress() {
      result = sut.addAddress(person.getId(), address);
      return self();
    }
  }

  protected static class ThenStage extends Stage<ThenStage> {

    @ExpectedScenarioState
    private Personen personen;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Person person;

    @ExpectedScenarioState
    private Address address;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Person createdPerson;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Optional<Person> result;

    public ThenStage create_was_called_on_Personen() {
      verify(personen).create(person);
      return self();
    }

    public ThenStage created_person_is_returned() {
      assertThat(createdPerson).isEqualTo(person);
      return self();
    }

    public ThenStage addAddress_was_called_on_Personen() {
      verify(personen).addAddress(person.getId(), address);
      return self();
    }

    public ThenStage person_is_returned() {
      assertThat(result).isEqualTo(Optional.of(person));
      return self();
    }

    public ThenStage no_person_is_returned() {
      assertThat(result).isEqualTo(Optional.empty());
      return self();
    }
  }
}
