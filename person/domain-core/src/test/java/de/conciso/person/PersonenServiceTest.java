package de.conciso.person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class PersonenServiceTest {
  private static final int ID = 42;
  private static final String VORNAME = "someVorname";
  private static final String NAME = "someName";
  private static final String STRASSE = "someStrasse";
  private static final int PLZ = 12345;
  private static final String ORT = "someOrt";

  @Mock
  PersonDAO personDAO;

  @InjectMocks
  PersonenService cut;

  @Nested
  class Given_testPerson {

    private Person testPerson;

    @BeforeEach
    void arrange() {
      testPerson = new Person(ID, VORNAME, NAME);
    }

    @Nested
    class Given_person_can_be_saved {

      @BeforeEach
      void arrange() {
        given(personDAO.save(any(Person.class))).willReturn(testPerson);
      }

      @Nested
      class When_calling_create {
        Person result;

        @BeforeEach
        void act() {
          result = cut.create(VORNAME, NAME);
        }

        @Test
        void then_PersonDAO_is_called() {
          verify(personDAO).save(new Person(VORNAME, NAME));
        }

        @Test
        void then_result_is_correct() {
          assertThat(result).isEqualTo(testPerson);
        }
      }
    }

    @Nested
    class Given_person_can_be_found {

      @BeforeEach
      void arrange() {
        given(personDAO.findById(anyInt())).willReturn(Optional.of(testPerson));
      }

      @Nested
      class When_calling_findById {
        Optional<Person> result;

        @BeforeEach
        void act() {
          result = cut.findById(ID);
        }

        @Test
        void then_PersonDAO_is_called() {
          verify(personDAO).findById(ID);
        }

        @Test
        void then_result_is_person() {
          assertThat(result).isEqualTo(Optional.of(testPerson));
        }
      }

      @Nested
      class When_calling_addAddress {
        Optional<Person> result;

        @BeforeEach
        void act() {
          result = cut.addAddress(ID, STRASSE, PLZ, ORT);
        }

        @Test
        void then_PersonDAO_is_called() {
          verify(personDAO).findById(ID);
        }

        @Test
        void then_result_is_person_with_address() {
          testPerson.addAddress(new Address(STRASSE, PLZ, ORT));
          assertThat(result).isEqualTo(Optional.of(testPerson));
        }
      }
    }
  }

  @Nested
  class Given_person_cannot_be_found {

    @BeforeEach
    void arrange() {
      given(personDAO.findById(anyInt())).willReturn(Optional.empty());
    }

    @Nested
    class When_calling_findById {
      Optional<Person> result;

      @BeforeEach
      void act() {
        result = cut.findById(ID);
      }

      @Test
      void then_PersonDAO_is_called() {
        verify(personDAO).findById(ID);
      }

      @Test
      void then_result_is_empty() {
        assertThat(result).isEqualTo(Optional.empty());
      }
    }

    @Nested
    class When_calling_addAddress {
      Optional<Person> result;

      @BeforeEach
      void act() {
        result = cut.addAddress(ID, STRASSE, PLZ, ORT);
      }

      @Test
      void then_PersonDAO_is_called() {
        verify(personDAO).findById(ID);
      }

      @Test
      void then_result_is_empty() {
        assertThat(result).isEqualTo(Optional.empty());
      }
    }
  }
}
