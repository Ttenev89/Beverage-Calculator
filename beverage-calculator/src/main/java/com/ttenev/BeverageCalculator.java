package com.ttenev;

import com.ttenev.models.Product;
import com.ttenev.utiles.InputReader;

public class BeverageCalculator {

  public static void main(String[] args) {
    Product.CalculatorService calculatorService = new Product.CalculatorService();
    InputReader reader = new InputReader();
    long[] input = reader.validateInput();

    calculatorService.executeOrder(input);
  }
}
