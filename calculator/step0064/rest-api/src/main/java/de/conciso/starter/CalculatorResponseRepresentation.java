package de.conciso.starter;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CalculatorResponseRepresentation {
  double result;
}
