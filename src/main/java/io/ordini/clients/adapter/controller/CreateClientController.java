package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.application.CreateClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Client")
@RestController
@RequestMapping("/client")
public class CreateClientController {

  private final CreateClientUseCase createClientUseCase;

  @PostMapping(value = "/create")
  @Operation(summary = "Create client", description = "Create new client.")
  public ResponseEntity<ClientPresenter.ClientResponse> create(
      @RequestBody @Valid ClientPresenter.ClientRequest clientRequest) {

    ClientPresenter.ClientResponse client = createClientUseCase.execute(clientRequest);

    return ResponseEntity.status(201).body(client);
  }
}
