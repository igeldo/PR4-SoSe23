package de.conciso.shop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AddressRestClientRepresentationNestedTest {

  @Nested
  class Given_address {

    Address address;

    @BeforeEach
    void arrange() {
      address = Address.builder()
          .strasse("Pariser Bogen 7")
          .plz(44269)
          .ort("Dortmund")
          .build();
    }

    @Nested
    class When_calling_from {

      AddressRestClientRepresentation result;

      @BeforeEach
      void act() {
        result = AddressRestClientRepresentation.from(address);
      }

      @Test
      void then_representation_is_correct() {
        var expected = AddressRestClientRepresentation.builder()
            .strasse("Pariser Bogen 7")
            .plz(44269)
            .ort("Dortmund")
            .build();
        assertThat(result).isEqualTo(expected);
      }
    }
  }

  @Nested
  class Given_representation {

    AddressRestClientRepresentation representation;

    @BeforeEach
    void arrange() {
      representation = AddressRestClientRepresentation.builder()
          .strasse("Pariser Bogen 7")
          .plz(44269)
          .ort("Dortmund")
          .build();
    }

    @Nested
    class When_calling_toAddress {

      Address result;

      @BeforeEach
      void act() {
        result = representation.toAddress();
      }

      @Test
      void then_address_is_correct() {
        var expected = Address.builder()
            .strasse("Pariser Bogen 7")
            .plz(44269)
            .ort("Dortmund")
            .build();
        assertThat(result).isEqualTo(expected);
      }
    }
  }
}
