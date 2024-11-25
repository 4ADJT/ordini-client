package io.ordini.clients.adapter.presenter.client;

import io.ordini.clients.domain.model.client.ClientModel;
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
      long latitude,
      ClientModel client
  ) {
  }

  @Builder
  public record ClientAddressResponse(
      UUID id,
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
  ) {}

}
