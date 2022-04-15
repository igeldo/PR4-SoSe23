package de.conciso.client.calculator;

import org.immutables.value.Value;

@Value.Immutable
public interface CalculatorRequestRepresentation {

  double getFirstNumber();

  double getSecondNumber();

  char getOperator();
}
