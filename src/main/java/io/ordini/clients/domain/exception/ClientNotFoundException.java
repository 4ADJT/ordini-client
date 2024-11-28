package io.ordini.clients.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClientNotFoundException extends RuntimeException {
  private HttpStatus status;

  public ClientNotFoundException(String message) {
    super(message);
  }

  public ClientNotFoundException(String defaultMessage, HttpStatus status) {
    super(defaultMessage);
    this.status = status;
  }
}
