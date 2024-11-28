package io.ordini.clients.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
