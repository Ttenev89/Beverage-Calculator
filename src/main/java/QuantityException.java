public class QuantityException extends Exception {

  public static final String INVALID_QUANTITY_MESSAGE = "Invalid product quantity entered!";

  @Override
  public String getMessage() {
    return INVALID_QUANTITY_MESSAGE;
  }
}
