package de.conciso.shop;

import static org.assertj.core.api.Assertions.assertThat;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.junit5.JGivenExtension;
import com.tngtech.jgiven.junit5.ScenarioTest;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(JGivenExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AddressRestClientRepresentationJGivenTest extends ScenarioTest<AddressRestClientRepresentationJGivenTest.GivenStage, AddressRestClientRepresentationJGivenTest.WhenStage, AddressRestClientRepresentationJGivenTest.ThenStage> {

  @Test
  void toAddress_should_create_address() {

    given().representation("Pariser Bogen 7", 44269, "Dortmund");

    when().calling_toAddress();

    then().address_is("Pariser Bogen 7", 44269, "Dortmund");
  }

  @Test
  void from_should_create_representation() {

    given().address("Pariser Bogen 7", 44269, "Dortmund");

    when().calling_from();

    then().representation_is("Pariser Bogen 7", 44269, "Dortmund");
  }

  protected static class GivenStage extends Stage<GivenStage> {

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private AddressRestClientRepresentation representation;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Address address;

    public GivenStage representation(String strasse, int plz, String ort) {
      representation = AddressRestClientRepresentation.builder()
          .strasse(strasse)
          .plz(plz)
          .ort(ort)
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
  }

  protected static class WhenStage extends Stage<WhenStage> {

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private AddressRestClientRepresentation representation;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Address address;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private AddressRestClientRepresentation representationResult;

    @ProvidedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Address addressResult;

    public WhenStage calling_toAddress() {
      addressResult = representation.toAddress();
      return self();
    }

    public WhenStage calling_from() {
      representationResult = AddressRestClientRepresentation.from(address);
      return self();
    }
  }

  protected static class ThenStage extends Stage<ThenStage> {

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private AddressRestClientRepresentation representationResult;

    @ExpectedScenarioState(resolution = ScenarioState.Resolution.NAME)
    private Address addressResult;

    public ThenStage address_is(String strasse, int plz, String ort) {
      var excpeted = Address.builder()
          .strasse(strasse)
          .plz(plz)
          .ort(ort)
          .build();
      assertThat(addressResult).isEqualTo(excpeted);
      return self();
    }

    public ThenStage representation_is(String strasse, int plz, String ort) {
      var excpeted = AddressRestClientRepresentation.builder()
          .strasse(strasse)
          .plz(plz)
          .ort(ort)
          .build();
      assertThat(representationResult).isEqualTo(excpeted);
      return self();
    }
  }
}
