package de.conciso.starter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

  private static final double FIRST_NUMBER = 6.0;
  private static final double SECOND_NUMBER = 7.0;
  private static final char OPERATOR = '*';
  private static final double RESULT_VALUE = 42.0;
  private static final char UNKNOWN_OPERATOR = '#';

  @Mock
  Calculator calculator;

  @InjectMocks
  CalculatorController cut;

  @Nested
  class Given_calculator_returns_result {

    @BeforeEach
    void arrange() {
      given(calculator.calculate(anyDouble(), anyDouble(), any(Operator.class))).willReturn(RESULT_VALUE);
    }

    @Nested
    class When_calling_calculate {
      ResponseEntity<CalculatorResponseRepresentation> response;

      @BeforeEach
      void act() {
        response = cut.calculate(new CalculatorRequestRepresentation(FIRST_NUMBER, SECOND_NUMBER, OPERATOR));
      }

      @Test
      void then_service_is_called(){
        verify(calculator).calculate(FIRST_NUMBER, SECOND_NUMBER, Operator.MULTIPLY);
      }

      @Test
      void then_status_code_is_200() {
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
      }

      @Test
      void then_result_is_correct() {
        assertThat(response.getBody()).isEqualTo(new CalculatorResponseRepresentation(RESULT_VALUE));
      }
    }
  }

  @Nested
  class Given_calculator_throws_exception {

    @BeforeEach
    void arrange() {
      given(calculator.calculate(anyDouble(), anyDouble(), any(Operator.class))).willThrow(IllegalStateException.class);
    }

    @Nested
    class When_calling_calculate {
      ResponseEntity<CalculatorResponseRepresentation> response;

      @BeforeEach
      void act() {
        response = cut.calculate(new CalculatorRequestRepresentation(FIRST_NUMBER, SECOND_NUMBER, OPERATOR));
      }

      @Test
      void then_service_is_called(){
        verify(calculator).calculate(FIRST_NUMBER, SECOND_NUMBER, Operator.MULTIPLY);
      }

      @Test
      void then_status_code_is_500() {
        assertThat(response.getStatusCodeValue()).isEqualTo(500);
      }

      @Test
      void then_body_is_empty() {
        assertThat(response.hasBody()).isFalse();
      }
    }
  }

  @Nested
  class Given_unknown_operator_symbol {

    @Nested
    class When_calling_calculate {
      ResponseEntity<CalculatorResponseRepresentation> response;

      @BeforeEach
      void act() {
        response = cut.calculate(new CalculatorRequestRepresentation(FIRST_NUMBER, SECOND_NUMBER, UNKNOWN_OPERATOR));
      }

      @Test
      void then_service_is_not_called(){
        verify(calculator, never()).calculate(FIRST_NUMBER, SECOND_NUMBER, Operator.MULTIPLY);
      }

      @Test
      void then_status_code_is_400() {
        assertThat(response.getStatusCodeValue()).isEqualTo(400);
      }

      @Test
      void then_body_is_empty() {
        assertThat(response.hasBody()).isFalse();
      }
    }
  }
}
