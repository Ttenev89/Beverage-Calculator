package com.ttenev.models;

public class ComplexValue {

  private final int type;
  private final double value;

  public ComplexValue(int type, double value) {
    this.type = type;
    this.value = value;
  }

  public int getType() {
    return this.type;
  }

  public double getValue() {
    return this.value;
  }
}
