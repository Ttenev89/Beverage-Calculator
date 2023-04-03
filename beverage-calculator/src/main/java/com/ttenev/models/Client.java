package com.ttenev.models;

public class Client {
  private final int id;
  private final int basicDiscount;
  private final int discountAbove10k;
  private final int discountAbove30k;

  public Client(int id, int basicDiscount, int discountAbove10k, int discountAbove30k) {
    this.id = id;
    this.basicDiscount = basicDiscount;
    this.discountAbove10k = discountAbove10k;
    this.discountAbove30k = discountAbove30k;
  }

  public int getId() {
    return this.id;
  }

  public int getBasicDiscount() {
    return this.basicDiscount;
  }

  public int getDiscountAbove10k() {
    return this.discountAbove10k;
  }

  public int getDiscountAbove30k() {
    return this.discountAbove30k;
  }
}
