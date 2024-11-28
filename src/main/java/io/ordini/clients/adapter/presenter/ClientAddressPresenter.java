package io.ordini.clients.adapter.presenter;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClientAddressPresenter {

  @Builder
  public record ClientAddressRequest(
      String street,
      int number,
      String complement,
      String neighborhood,
      String city,
      String state,
      String country,
      String zipCode,
      long longitude,
      long latitude
  ) {
  }

  @Builder
  public record ClientAddressUpdateRequest(
      UUID clientId,
      String street,
      int number,
      String complement,
      String neighborhood,
      String city,
      String state,
      String country,
      String zipCode,
      long longitude,
      long latitude
  ) {
  }

  @Builder
  public record ClientAddressResponse(
      UUID id,
      UUID clientId,
      String street,
      int number,
      String complement,
      String neighborhood,
      String city,
      String state,
      String country,
      String zipCode,
      long longitude,
      long latitude,
      LocalDateTime createdAt
  ) {
  }

  @Builder
  public record ClientAddressUpdateResponse(
      UUID id,
      UUID clientId,
      String street,
      int number,
      String complement,
      String neighborhood,
      String city,
      String state,
      String country,
      String zipCode,
      long longitude,
      long latitude,
      LocalDateTime createdAt,
      LocalDateTime updatedAt
  ) {
  }

}
