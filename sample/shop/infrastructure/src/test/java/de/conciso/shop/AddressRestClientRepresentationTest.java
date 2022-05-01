package de.conciso.shop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AddressRestClientRepresentationTest {

  @Test
  void from_should_create_representation() {

    // Arrange
    var address = Address.builder()
        .strasse("Pariser Bogen 7")
        .plz(44269)
        .ort("Dortmund")
        .build();
    var expected = AddressRestClientRepresentation.builder()
        .strasse("Pariser Bogen 7")
        .plz(44269)
        .ort("Dortmund")
        .build();

    // Act
    var result = AddressRestClientRepresentation.from(address);

    // Assert
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void toAddress_should_create_address() {

    // Arrange
    var representation = AddressRestClientRepresentation.builder()
        .strasse("Pariser Bogen 7")
        .plz(44269)
        .ort("Dortmund")
        .build();
    var expected = Address.builder()
        .strasse("Pariser Bogen 7")
        .plz(44269)
        .ort("Dortmund")
        .build();;

    // Act
    var result = representation.toAddress();

    // Assert
    assertThat(result).isEqualTo(expected);
  }
}
