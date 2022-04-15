package de.conciso.starter;

import java.util.Objects;

public class CalculatorResponseRepresentation {
  private final double result;

  public CalculatorResponseRepresentation(double result) {
    this.result = result;
  }

  public double getResult() {
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CalculatorResponseRepresentation that = (CalculatorResponseRepresentation) o;
    return Double.compare(that.result, result) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }
}
