package com.ttenev.exceptions;

public class IdException extends Exception {

  public static final String INVALID_ID_MESSAGE = "Invalid client ID entered!";

  @Override
  public String getMessage() {
    return INVALID_ID_MESSAGE;
  }
}
