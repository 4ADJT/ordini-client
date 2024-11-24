package io.ordini.clients.adapter.presenter.dto.client;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClientPresenter {

  @Builder
  public record ClientAddressRequest(
      String street,
      int number,
      String complement,
      String neighborhood,
      String city,
      String state,
      String country,
      String zipCode
  ) {
  }

  @Builder
  public record ClientRequest(
      String name,
      String email,
      String phone,
      String cellphone,
      String document,
      ClientAddressRequest address
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
      String zipCode
  ) {}

  @Builder
  public record ClientResponse(
      UUID id,
      String name,
      String email,
      String phone,
      String cellphone,
      String document,
      ClientAddressResponse address,
      LocalDateTime createdAt
  ) {
  }

}
