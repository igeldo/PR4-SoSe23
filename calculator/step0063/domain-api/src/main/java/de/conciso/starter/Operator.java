package de.conciso.starter;

import java.util.Arrays;

public enum Operator {
  ADD('+'),
  SUBTRACT('-'),
  MULTIPLY('*'),
  DIVIDE('/');

  private final char symbol;

  Operator(char symbol) {
    this.symbol = symbol;
  }

  public char getSymbol() {
    return symbol;
  }

  public static Operator from(char symbol) {
    return Arrays.stream(Operator.values())
        .filter(value -> symbol == value.getSymbol())
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("unknown symbol " + symbol));
  }
}
