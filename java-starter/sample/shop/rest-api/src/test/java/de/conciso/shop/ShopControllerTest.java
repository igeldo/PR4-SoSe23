package de.conciso.shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class ShopControllerTest {

  private static final int ID = 42;
  private static final String VORNAME = "someVorname";
  private static final String NAME = "someName";
  private static final String STRASSE = "someStrasse";
  private static final int PLZ = 12345;
  private static final String ORT = "someOrt";

  @Mock
  Shop personen;

  @InjectMocks
  ShopController cut;

  @Nested
  class Given_person_can_be_created {

    @BeforeEach
    void arrange() {
      var person = Person.builder()
          .id(ID)
          .vorname(VORNAME)
          .name(NAME)
          .adresses(List.of())
          .build();
      given(personen.createPerson(any(Person.class))).willReturn(person);
    }

    @Nested
    class When_calling_create {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        var personRepresentation = PersonRepresentation.builder()
            .vorname(VORNAME)
            .name(NAME)
            .build();
        result = cut.create(personRepresentation);
      }

      @Test
      void then_PersonenService_is_called() {
        var person = Person.builder()
            .vorname(VORNAME)
            .name(NAME)
            .build();
        verify(personen).createPerson(person);
      }

      @Test
      void then_status_is_OK() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
      }

      @Test
      void then_body_is_correct() {
        var expected = PersonRepresentation.builder()
            .id(ID)
            .vorname(VORNAME)
            .name(NAME)
            .addresses(List.of())
            .build();
        assertThat(result.getBody()).isEqualTo(expected);
      }
    }
  }

  @Nested
  class Given_create_person_throws_exception {

    @BeforeEach
    void arrange() {
      given(personen.createPerson(any(Person.class))).willThrow(IllegalStateException.class);
    }

    @Nested
    class When_calling_create {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        var personRepresentation = PersonRepresentation.builder()
            .vorname(VORNAME)
            .name(NAME)
            .build();
        result = cut.create(personRepresentation);
      }

      @Test
      void then_PersonenService_is_called() {
        var person = Person.builder()
            .vorname(VORNAME)
            .name(NAME)
            .build();
        verify(personen).createPerson(person);
      }

      @Test
      void then_status_is_INTERNAL_SERVER_ERRORT() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
      }

      @Test
      void then_body_is_empty() {
        assertThat(result.hasBody()).isFalse();
      }
    }
  }

  @Nested
  class Given_person_can_be_found {

    @BeforeEach
    void arrange() {
      var person = Person.builder()
          .id(ID)
          .vorname(VORNAME)
          .name(NAME)
          .adresses(List.of())
          .build();
      given(personen.findPerson(anyInt())).willReturn(Optional.of(person));
    }

    @Nested
    class When_calling_findById {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findPerson(ID);
      }

      @Test
      void then_PersonenService_is_called() {
        verify(personen).findPerson(ID);
      }

      @Test
      void then_status_is_OK() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
      }

      @Test
      void then_body_is_correct() {
        var expected = PersonRepresentation.builder()
            .id(ID)
            .vorname(VORNAME)
            .name(NAME)
            .addresses(List.of())
            .build();
        assertThat(result.getBody()).isEqualTo(expected);
      }
    }
  }

  @Nested
  class Given_person_cannot_be_found {

    @BeforeEach
    void arrange() {
      given(personen.findPerson(anyInt())).willReturn(Optional.empty());
    }

    @Nested
    class When_calling_findById {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findPerson(ID);
      }

      @Test
      void then_PersonenService_is_called() {
        verify(personen).findPerson(ID);
      }

      @Test
      void then_status_is_NOT_FOUND() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
      }

      @Test
      void then_body_is_empty() {
        assertThat(result.hasBody()).isFalse();
      }
    }
  }

  @Nested
  class Given_find_person_throws_exception {

    @BeforeEach
    void arrange() {
      given(personen.findPerson(anyInt())).willThrow(IllegalStateException.class);
    }

    @Nested
    class When_calling_findById {
      ResponseEntity<PersonRepresentation> result;

      @BeforeEach
      void act() {
        result = cut.findPerson(ID);
      }

      @Test
      void then_PersonenService_is_called() {
        verify(personen).findPerson(ID);
      }

      @Test
      void then_status_is_INTERNAL_SERVER_ERROR() {
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
      }

      @Test
      void then_body_is_empty() {
        assertThat(result.hasBody()).isFalse();
      }
    }
  }

  @Nested
  class Given_address_and_adressRepresentation {
    private Address address;
    private AddressRepresentation addressRepresentation;

    @BeforeEach
    void arrange() {
      address = Address.builder()
          .strasse(STRASSE)
          .plz(PLZ)
          .ort(ORT)
          .build();
      addressRepresentation = AddressRepresentation.builder()
          .strasse(STRASSE)
          .plz(PLZ)
          .ort(ORT)
          .build();
    }

    @Nested
    class Given_address_can_be_added {

      @BeforeEach
      void arrange() {
        var person = Person.builder()
            .id(ID)
            .vorname(VORNAME)
            .name(NAME)
            .adresses(List.of(address))
            .build();
        given(personen.addAddress(anyInt(), any(Address.class))).willReturn(Optional.of(person));
      }

      @Nested
      class When_calling_addAddress {
        ResponseEntity<PersonRepresentation> result;

        @BeforeEach
        void act() {
          result = cut.addAddress(ID, addressRepresentation);
        }

        @Test
        void then_PersonenService_is_called() {
          verify(personen).addAddress(ID, address);
        }

        @Test
        void then_status_is_OK() {
          assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        }

        @Test
        void then_body_is_correct() {
          var expected = PersonRepresentation.builder()
              .id(ID)
              .vorname(VORNAME)
              .name(NAME)
              .addresses(List.of(addressRepresentation))
              .build();
          assertThat(result.getBody()).isEqualTo(expected);
        }
      }
    }

    @Nested
    class Given_address_cannot_be_added {

      @BeforeEach
      void arrange() {
        given(personen.addAddress(anyInt(), any(Address.class))).willReturn(Optional.empty());
      }

      @Nested
      class When_calling_addAddress {
        ResponseEntity<PersonRepresentation> result;

        @BeforeEach
        void act() {
          result = cut.addAddress(ID, addressRepresentation);
        }

        @Test
        void then_PersonenService_is_called() {
          verify(personen).addAddress(ID, address);
        }

        @Test
        void then_status_is_NOT_FOUND() {
          assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        }

        @Test
        void then_body_is_empty() {
          assertThat(result.hasBody()).isFalse();
        }
      }
    }

    @Nested
    class Given_addAddress_throws_exception {

      @BeforeEach
      void arrange() {
        given(personen.addAddress(anyInt(), any(Address.class))).willThrow(IllegalStateException.class);
      }

      @Nested
      class When_calling_addAddress {
        ResponseEntity<PersonRepresentation> result;

        @BeforeEach
        void act() {
          result = cut.addAddress(ID, addressRepresentation);
        }

        @Test
        void then_PersonenService_is_called() {
          verify(personen).addAddress(ID, address);
        }

        @Test
        void then_status_is_INTERNAL_SERVER_ERROR() {
          assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @Test
        void then_body_is_empty() {
          assertThat(result.hasBody()).isFalse();
        }
      }
    }
  }
}
