package io.ordini.clients.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClientAddressAlreadyCreatedException extends RuntimeException {
  private HttpStatus status;

  public ClientAddressAlreadyCreatedException(String message) {
    super(message);
  }

  public ClientAddressAlreadyCreatedException(String defaultMessage, HttpStatus status) {
    super(defaultMessage);
    this.status = status;
  }

}
