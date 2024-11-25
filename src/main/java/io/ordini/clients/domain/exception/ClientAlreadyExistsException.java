package io.ordini.clients.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClientAlreadyExistsException extends RuntimeException {
  private HttpStatus status;

  public ClientAlreadyExistsException(String message) {
    super(message);
  }

  public ClientAlreadyExistsException(String defaultMessage, HttpStatus status) {
    super(defaultMessage);
    this.status = status;
  }
}
