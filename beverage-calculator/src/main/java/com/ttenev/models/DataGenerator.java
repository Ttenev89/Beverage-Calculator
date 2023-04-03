package com.ttenev.models;

import com.ttenev.utiles.ComplexValue;

public class DataGenerator {

    /*
       За целите на задачата входните данни се създават тук.
       В реална постановка би трябвало да се извличат от база данни.
    */

  private final ComplexValue markupA = new ComplexValue(1, 80);
  private final ComplexValue markupB = new ComplexValue(1, 120);
  private final ComplexValue markupC = new ComplexValue(2, 0.9);
  private final ComplexValue markupD = new ComplexValue(2, 1);

  private final ComplexValue promotionO = new ComplexValue(0, 0);
  private final ComplexValue promotionB = new ComplexValue(1, 30);
  private final ComplexValue promotionD = new ComplexValue(2, 3);

  private final Product productA = new Product("A", 0.52, markupA, promotionO);
  private final Product productB = new Product("B", 0.38, markupB, promotionB);
  private final Product productC = new Product("C", 0.41, markupC, promotionO);
  private final Product productD = new Product("D", 0.6, markupD, promotionD);
  private final Product[] products = {productA, productB, productC, productD};

  private final Client client1 = new Client(1, 5, 0, 2);
  private final Client client2 = new Client(2, 4, 1, 2);
  private final Client client3 = new Client(3, 3, 1, 3);
  private final Client client4 = new Client(4, 2, 3, 5);
  private final Client client5 = new Client(5, 0, 5, 7);
  private final Client[] clients = {client1, client2, client3, client4, client5};

  public Client[] getClients() {
    return this.clients;
  }

  public Product[] getProducts() {
    return this.products;
  }
}
