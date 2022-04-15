package de.conciso.starter;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements Calculator {

  @Override
  public double calculate(double firstNumber, double secondNumber, Operator operator) {
    switch (operator) {
      case ADD:
        return firstNumber + secondNumber;
      case SUBTRACT:
        return firstNumber - secondNumber;
      case MULTIPLY:
        return firstNumber * secondNumber;
      case DIVIDE:
        return firstNumber / secondNumber;
    }
    throw new IllegalArgumentException("unknown operator: " + operator);
  }
}
