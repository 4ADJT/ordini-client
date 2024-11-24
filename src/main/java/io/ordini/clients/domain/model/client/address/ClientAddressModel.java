package io.ordini.clients.domain.model.client.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
