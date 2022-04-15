package de.conciso.starter;

public class CalculatorRequestRepresentation {
  private final double firstNumber;
  private final double secondNumber;
  private final char operator;

  public CalculatorRequestRepresentation(double firstNumber, double secondNumber, char operator) {
    this.firstNumber = firstNumber;
    this.secondNumber = secondNumber;
    this.operator = operator;
  }

  public double getFirstNumber() {
    return firstNumber;
  }

  public double getSecondNumber() {
    return secondNumber;
  }

  public char getOperator() {
    return operator;
  }
}
