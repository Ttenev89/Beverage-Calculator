package com.ttenev.tests;

import com.ttenev.models.Client;
import com.ttenev.models.Product;
import com.ttenev.models.DataGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

  private final static Product.CalculatorService calculatorService = new Product.CalculatorService();
  private final static DataGenerator data = new DataGenerator();
  private final static Product[] products = data.getProducts();
  private final static Client[] clients = data.getClients();

  @Test
  void getMarkupPriceTest() {
    double expectedValue = calculatorService.getMarkupPrice(products[0]);
    double desiredValue = 0.52 + 0.52 * 80 / 100;

    assertEquals(expectedValue, desiredValue);
  }

  @Test
  void getOrderTotalTest() {
    double expectedValue = calculatorService.getOrderTotal(31000, 4, 1);
    double temp = 31000 - (double) 31000 * 4 / 100;
    double desiredValue = temp - temp * 1 / 100;

    assertEquals(expectedValue, desiredValue);
  }

  @Test
  void printProductInfoTest() {
    double expectedValue = calculatorService.calculateTotalProductPrice(products[0], 5000);
    double desiredValue = 5000 * (0.52 + 0.52 * 80 / 100);

    assertEquals(expectedValue, desiredValue);
  }

  @Test
  void setAdditionalDiscountUnder10KTest() {
    double expectedValue = calculatorService.setAdditionalDiscount(clients[0], 5000);
    double desiredValue = 0;

    assertEquals(expectedValue, desiredValue);
  }

  @Test
  void setAdditionalDiscountAbove10KTest() {
    double expectedValue = calculatorService.setAdditionalDiscount(clients[0], 15000);
    double desiredValue = clients[0].getDiscountAbove10k();

    assertEquals(expectedValue, desiredValue);
  }

  @Test
  void setAdditionalDiscountAbove30KTest() {
    double expectedValue = calculatorService.setAdditionalDiscount(clients[0], 35000);
    double desiredValue = clients[0].getDiscountAbove30k();

    assertEquals(expectedValue, desiredValue);
  }
}