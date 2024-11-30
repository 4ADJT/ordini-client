package io.ordini.clients.domain.model;

import io.ordini.clients.domain.exception.ModelValidationIllegalArgumentException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientAddressModel {

  private UUID id;
  private String street;
  private int number;
  private String complement;
  private String neighborhood;
  private String city;
  private String state;
  private String country;
  private String zipCode;
  private long longitude;
  private long latitude;
  private ClientModel client;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public void validate() {
    if (street == null || street.trim().isEmpty()) {
      throw new ModelValidationIllegalArgumentException("O campo 'street' não pode ser nulo ou vazio.", HttpStatus.BAD_REQUEST);
    }
    if (city == null || city.trim().isEmpty()) {
      throw new ModelValidationIllegalArgumentException("O campo 'city' não pode ser nulo ou vazio.", HttpStatus.BAD_REQUEST);
    }
    if (state == null || state.trim().isEmpty()) {
      throw new ModelValidationIllegalArgumentException("O campo 'state' não pode ser nulo ou vazio.", HttpStatus.BAD_REQUEST);
    }
    if (country == null || country.trim().isEmpty()) {
      throw new ModelValidationIllegalArgumentException("O campo 'country' não pode ser nulo ou vazio.", HttpStatus.BAD_REQUEST);
    }
    if (zipCode == null || zipCode.trim().isEmpty()) {
      throw new ModelValidationIllegalArgumentException("O campo 'zipCode' não pode ser nulo ou vazio.", HttpStatus.BAD_REQUEST);
    }
  }

}
