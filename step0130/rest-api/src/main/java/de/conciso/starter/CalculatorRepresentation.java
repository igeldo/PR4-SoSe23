package de.conciso.starter;

import lombok.Data;

@Data
public class CalculatorRepresentation {

    private double firstNumber;

    private double secondNumber;

    private double result;

    private char currentOperator;
}
