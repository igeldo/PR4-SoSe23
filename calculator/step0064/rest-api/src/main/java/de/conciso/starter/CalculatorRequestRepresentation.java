package de.conciso.starter;

import lombok.Value;

@Value
public class CalculatorRequestRepresentation {
  double firstNumber;
  double secondNumber;
  char operator;
}
