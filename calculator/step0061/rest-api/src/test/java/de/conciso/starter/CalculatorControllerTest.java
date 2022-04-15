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
  void adding_3_and_4_gives_7() {
    // Act
    var result = cut.calculate(3.0, 4.0, '+');

    // Assert
    assertThat(result).isEqualTo("7.0");
  }

  @Test
  void subtracting_4_from_3_gives_minus_1() {
    // Act
    var result = cut.calculate(3.0, 4.0, '-');

    // Assert
    assertThat(result).isEqualTo("-1.0");
  }

  @Test
  void multiplying_3_times_4_gives_12() {
    // Act
    var result = cut.calculate(3.0, 4.0, '*');

    // Assert
    assertThat(result).isEqualTo("12.0");
  }

  @Test
  void dividing_3_by_4_gives_0_point_75() {
    // Act
    var result = cut.calculate(3.0, 4.0, '/');

    // Assert
    assertThat(result).isEqualTo("0.75");
  }
}
