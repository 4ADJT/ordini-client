package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.gateway.ms.ClientPublisherService;
import io.ordini.clients.adapter.presenter.ClientAddressPresenter;
import io.ordini.clients.application.CreateClientAddressUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@Tag(name = "Client Address")
@RestController
@RequestMapping("/client/address")
public class CreateClientAddressController {

  private final CreateClientAddressUseCase createClientAddressUseCase;
  private final ClientPublisherService clientPublisherService;

  @PostMapping(value = "/create", produces = "application/json")
  @Operation(summary = "Create client address", description = "Create client address.")
  public ResponseEntity<ClientAddressPresenter.ClientAddressResponse> createClientAddress(
      @RequestBody ClientAddressPresenter.ClientAddressRequest request,
      @RequestParam(value = "client_id") UUID clientId)
  {
    ClientAddressPresenter.ClientAddressResponse response = createClientAddressUseCase.execute(clientId, request);

    clientPublisherService.publishNewClientEvent(response.clientId().toString());

    return ResponseEntity.status(201).body(response);
  }

}
