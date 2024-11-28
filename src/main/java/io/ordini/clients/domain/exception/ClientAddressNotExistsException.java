package io.ordini.clients.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClientAddressNotExistsException extends RuntimeException {
  private HttpStatus status;

  public ClientAddressNotExistsException(String message) {
    super(message);
  }

  public ClientAddressNotExistsException(String defaultMessage, HttpStatus status) {
    super(defaultMessage);
    this.status = status;
  }
}
