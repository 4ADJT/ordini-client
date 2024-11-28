package io.ordini.clients.adapter.presenter.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClientPresenter {

  @Builder
  public record ClientRequest(

      @NonNull
      @NotEmpty
      String name,

      @Email
      String email,

      String phone,
      String cellphone,

      @CPF
      String document
  ) {
  }

  @Builder
  public record ClientUpdateRequest(

      @NonNull
      UUID id,

      @NonNull
      @NotEmpty
      String name,

      String phone,
      String cellphone

  ) {
  }

  @Builder
  public record ClientResponse(
      UUID id,
      String name,
      String email,
      String phone,
      String cellphone,
      String document,
      LocalDateTime createdAt
  ) {
  }

  @Builder
  public record ClientAndAddressResponse(
      UUID id,
      String name,
      String email,
      String phone,
      String cellphone,
      String document,
      ClientAddressPresenter.ClientAddressResponse address,
      LocalDateTime createdAt
  ) {
  }

}
