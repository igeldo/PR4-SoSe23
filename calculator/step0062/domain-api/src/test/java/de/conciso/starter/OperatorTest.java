package de.conciso.starter;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OperatorTest {

  @ParameterizedTest
  @MethodSource("provideParameters")
  void from_gives_correct_value(char symbol, Operator expected) {
    // Act
    var result = Operator.from(symbol);

    // Assert
    assertThat(result).isEqualTo(expected);
  }

  private static Stream<Arguments> provideParameters() {
    return Stream.of(
        Arguments.of('+', Operator.ADD),
        Arguments.of('-', Operator.SUBTRACT),
        Arguments.of('*', Operator.MULTIPLY),
        Arguments.of('/', Operator.DIVIDE)
    );
  }

  @Test
  void illegal_operator_throws_IllegalArgumentException() {
    // Act
    var exception = assertThrows(IllegalArgumentException.class, () -> Operator.from('#'));

    // Assert
    assertThat(exception).hasMessage("unknown symbol #");
  }
}
