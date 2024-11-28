package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.presenter.ClientAddressPresenter;
import io.ordini.clients.application.UpdateClientAddressUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Client Address")
@RestController
@RequestMapping("/client/address")
public class UpdateClientAddressController {

  private final UpdateClientAddressUseCase updateClientAddressUseCase;

  @PutMapping(value = "/update", produces = "application/json")
  @Operation(summary = "Update client address", description = "Update client address.")
  public ResponseEntity<ClientAddressPresenter.ClientAddressUpdateResponse> updateClientAddress(
      ClientAddressPresenter.ClientAddressUpdateRequest request)
  {
    ClientAddressPresenter.ClientAddressUpdateResponse response = updateClientAddressUseCase.execute(request);

    return ResponseEntity.status(200).body(response);
  }

}
