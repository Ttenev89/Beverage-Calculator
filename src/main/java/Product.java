public class Product {
  private final String type;
  private final double unitCost;
  private final ComplexValue markup;
  private final ComplexValue promotion;

  public Product(String type, double unitCost, ComplexValue markup, ComplexValue promotion) {
    this.type = type;
    this.unitCost = unitCost;
    this.markup = markup;
    this.promotion = promotion;
  }

  public String getType() {
    return this.type;
  }

  public double getUnitCost() {
    return this.unitCost;
  }

  public ComplexValue getMarkup() {
    return this.markup;
  }

  public ComplexValue getPromotion() {
    return this.promotion;
  }

    public static class CalculatorService {

      public void executeOrder(long[] input) {
        DataGenerator data = new DataGenerator();
        Client[] clients = data.getClients();

        for (Client client : clients) {
          if (client.getId() == input[0]) {
            calculateTotalOrder(client, data.getProducts(), input);
          }
        }
      }

      public double getMarkupPrice(Product product) {
        double markupPrice = product.getUnitCost();
        int markupType = product.getMarkup().getType();
        double markupValue = product.getMarkup().getValue();

        switch (markupType) {
          case 1:
            markupPrice += markupPrice * (markupValue / 100);
            break;
          case 2:
            markupPrice += markupValue;
            break;
        }
        return markupPrice;
      }

      private double[] applyPromotion(Product product, double markupPrice, long quantity) {
        double[] quantityAndFinalPrice = new double[2];
        int promotionType = product.getPromotion().getType();
        double promotionValue = product.getPromotion().getValue();

        switch (promotionType) {
          case 1:
            quantityAndFinalPrice[0] = quantity;
            quantityAndFinalPrice[1] = markupPrice - markupPrice * (promotionValue / 100);
            break;
          case 2:
            quantityAndFinalPrice[0] = Math.ceil((double) quantity / 3 * 2);
            quantityAndFinalPrice[1] = markupPrice;
            break;
          default:
            quantityAndFinalPrice[0] = quantity;
            quantityAndFinalPrice[1] = markupPrice;
            break;
        }
        return quantityAndFinalPrice;
      }

      public double getOrderTotal(double totalBeforeDiscount, int basicDiscount, int additionalDiscount) {
        double total, basicDiscountApplied;

        basicDiscountApplied = totalBeforeDiscount - totalBeforeDiscount * basicDiscount / 100;
        total = basicDiscountApplied - basicDiscountApplied * additionalDiscount / 100;

        return total;
      }

      public int setAdditionalDiscount(Client client, double totalBeforeDiscount) {
        if (totalBeforeDiscount > 10000 && totalBeforeDiscount < 30000) {
          return client.getDiscountAbove10k();
        } else if (totalBeforeDiscount > 30000) {
          return client.getDiscountAbove30k();
        } else {
          return 0;
        }
      }

      public double calculateTotalProductPrice(Product product, long quantity)
      {
        double markupPrice = getMarkupPrice(product);
        double[] quantityAndFinalPrice = applyPromotion(product, markupPrice, quantity);
        double newQuantity = quantityAndFinalPrice[0];

        return newQuantity * quantityAndFinalPrice[1];
      }

      public void printProductInfo(Product product, long quantity) {
        double markupPrice = getMarkupPrice(product);
        double[] quantityAndFinalPrice = applyPromotion(product, markupPrice, quantity);
        double newQuantity = quantityAndFinalPrice[0];
        double total = newQuantity * quantityAndFinalPrice[1];
        double finalPrice = total / quantity;

        System.out.println("Product ordered: Product " + product.getType());
        System.out.println("Quantity ordered: " + quantity);
        System.out.println("Base unit price: " + Math.round(markupPrice * 100.0) / 100.0 + " EUR");
        System.out.println("Promotional unit price: " + Math.round(finalPrice * 100.0) / 100.0 + " EUR");
        System.out.println("Total: " + Math.round(total * 100.0) / 100.0 + " EUR\n");
      }

      void calculateTotalOrder(Client client, Product[] products, long[] input) {
        double totalBeforeDiscount = 0,total;
        int basicDiscount = client.getBasicDiscount();
        int additionalDiscount;

        System.out.println("\nOrder summary:\n");

        for (int i = 0; i < products.length; i++) {
          if (input[i + 1] > 0) {
            totalBeforeDiscount += calculateTotalProductPrice(products[i], input[i + 1]);
            printProductInfo(products[i], input[i + 1]);
          }
        }
        additionalDiscount = setAdditionalDiscount(client, totalBeforeDiscount);
         total=getOrderTotal(totalBeforeDiscount, basicDiscount, additionalDiscount);
        printTotalOrder(totalBeforeDiscount,basicDiscount,additionalDiscount,total);
      }

      void printTotalOrder(double totalBeforeDiscount,int basicDiscount,int additionalDiscount,double total){
        System.out.println("Total amount before client discount: " + Math.round(totalBeforeDiscount * 100.0) / 100.0 + " EUR");
        System.out.println("Basic client discount applied: " + basicDiscount + "%");
        System.out.println("Additional volume discount applied: " + additionalDiscount + "%");
        System.out.println("Order total amount: " +Math.round(total* 100.0) / 100.0 + " EUR");
      }
    }
}
