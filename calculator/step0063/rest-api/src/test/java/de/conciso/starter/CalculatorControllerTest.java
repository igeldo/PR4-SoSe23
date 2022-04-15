package de.conciso.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

  CalculatorController cut;

  @BeforeEach
  void init() {
    cut = new CalculatorController();
  }

  @Test
  void controller_returns_status_code_200() {
    // Arrange
    var request = new CalculatorRequestRepresentation(3.0, 4.0, '+');

    // Act
    var result = cut.calculate(request);

    // Assert
    assertThat(result.getStatusCodeValue()).isEqualTo(200);
  }

  @Test
  void adding_3_and_4_gives_7() {
    // Arrange
    var request = new CalculatorRequestRepresentation(3.0, 4.0, '+');

    // Act
    var result = cut.calculate(request);

    // Assert
    assertThat(result.getBody()).isEqualTo(new CalculatorResponseRepresentation(7.0));
  }

  @Test
  void subtracting_4_from_3_gives_minus_1() {
    // Arrange
    var request = new CalculatorRequestRepresentation(3.0, 4.0, '-');

    // Act
    var result = cut.calculate(request);

    // Assert
    assertThat(result.getBody()).isEqualTo(new CalculatorResponseRepresentation(-1.0));
  }

  @Test
  void multiplying_3_times_4_gives_12() {
    // Arrange
    var request = new CalculatorRequestRepresentation(3.0, 4.0, '*');

    // Act
    var result = cut.calculate(request);

    // Assert
    assertThat(result.getBody()).isEqualTo(new CalculatorResponseRepresentation(12.0));
  }

  @Test
  void dividing_3_by_4_gives_0_point_75() {
    // Arrange
    var request = new CalculatorRequestRepresentation(3.0, 4.0, '/');

    // Act
    var result = cut.calculate(request);

    // Assert
    assertThat(result.getBody()).isEqualTo(new CalculatorResponseRepresentation(0.75));
  }
}
