package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.application.FindClientByDocumentUseCase;
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
public class FindClientByDocumentController {

  private final FindClientByDocumentUseCase findClientByDocumentUseCase;

  @GetMapping(value = "/find-document/{document}", produces = "application/json")
  @Operation(summary = "Find client by document", description = "Find client by document.")
  public ResponseEntity<ClientPresenter.ClientAndAddressResponse> findClientByEmail(
      @PathVariable String document
  ) {

    ClientPresenter.ClientAndAddressResponse client = findClientByDocumentUseCase.execute(document);

    return ResponseEntity.ok(client);
  }

}
