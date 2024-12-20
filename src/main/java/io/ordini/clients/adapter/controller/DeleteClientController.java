package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.application.DeleteClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@Tag(name = "Client")
@RestController
@RequestMapping("/client")
public class DeleteClientController {

  private final DeleteClientUseCase deleteClientUseCase;

  @DeleteMapping(value = "/delete/{clientId}")
  @Operation(summary = "Delete client by id",  description = "Delete client by id.")
  public ResponseEntity<ClientPresenter.ClientDeletedResponse> delete(
      @PathVariable UUID clientId
  ) {

    return ResponseEntity.status(200).body(
        ClientPresenter.ClientDeletedResponse.builder().id(deleteClientUseCase.execute(clientId)).build()
    );
  }

}
