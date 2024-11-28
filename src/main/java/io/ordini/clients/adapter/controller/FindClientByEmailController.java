package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.application.FindClientByEmailUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Client")
@RestController
@RequestMapping("/client")
public class FindClientByEmailController {

  private final FindClientByEmailUseCase findClientByEmailUseCase;

  @GetMapping(value = "/find/{email}", produces = "application/json")
  @Operation(summary = "Find client by email", description = "Find client by email.")
  public ResponseEntity<ClientPresenter.ClientAndAddressResponse> findClientByEmail(
      @PathVariable String email
  ) {

    ClientPresenter.ClientAndAddressResponse client = findClientByEmailUseCase.execute(email);

    return ResponseEntity.ok(client);
  }

}
