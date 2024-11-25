package io.ordini.clients.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ModelValidationIllegalArgumentException extends IllegalArgumentException {
  private HttpStatus status;

  public ModelValidationIllegalArgumentException(String message) {
    super(message);
  }

  public ModelValidationIllegalArgumentException(String defaultMessage, HttpStatus status) {
    super(defaultMessage);
    this.status = status;
  }

}
