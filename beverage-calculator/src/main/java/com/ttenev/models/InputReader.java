package com.ttenev.models;

import com.ttenev.exceptions.IdException;
import com.ttenev.exceptions.QuantityException;

import java.util.Scanner;

public class InputReader {

  Scanner scanner = new Scanner(System.in);
  long[] input = new long[5];
  boolean hasError = true;

  public long[] validateInput() {
    while (hasError) {
      hasError = false;
      try {
        for (int i = 0; i < 5; i++) {
          input[i] = Long.parseLong(scanner.next());

          if (i == 0) {
            if (input[i] != 1 && input[i] != 2 && input[i] != 3 && input[i] != 4 && input[i] != 5) {
              throw new IdException();
            }
          } else {
            if (input[i] < 0) {
              throw new QuantityException();
            }
          }
        }
      } catch (
        IdException idException) {
        hasError = true;
        System.out.println(idException.getMessage());
      } catch (
        QuantityException quantityException) {
        hasError = true;
        System.out.println(quantityException.getMessage());
      } catch (
        Exception exception) {
        hasError = true;
        System.out.println("Only numbers are allowed!");
      }
    }
    return input;
  }
}
