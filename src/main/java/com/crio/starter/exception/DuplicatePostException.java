package com.crio.starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatePostException extends RuntimeException {
  public DuplicatePostException(String message) {
    super(message);
  }
}

