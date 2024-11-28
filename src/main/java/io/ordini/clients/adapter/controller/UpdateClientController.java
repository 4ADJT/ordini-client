package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.application.UpdateClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Client")
@RestController
@RequestMapping("/client")
public class UpdateClientController {

  private final UpdateClientUseCase updateClientUseCase;

  @PutMapping(value = "/update")
  @Operation(summary = "Update client", description = "Update client by id.")
  public ResponseEntity<ClientPresenter.ClientResponse> update(
      @RequestBody @Valid ClientPresenter.ClientUpdateRequest clientUpdateRequest
      ) {

    ClientPresenter.ClientResponse client = updateClientUseCase.execute(clientUpdateRequest);

    return ResponseEntity.status(200).body(client);
  }

}
