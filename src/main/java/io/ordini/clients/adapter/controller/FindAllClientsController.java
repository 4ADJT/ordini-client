package io.ordini.clients.adapter.controller;

import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.application.FindAllClientsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Client")
@RestController
@RequestMapping("/client")
public class FindAllClientsController {

  private final FindAllClientsUseCase findAllClientsUseCase;

  @GetMapping(value = "/find-all", produces = "application/json")
  @Operation(summary = "Find all clients", description = "Find all clients.")
  public ResponseEntity<PagedModel<ClientPresenter.ClientAndAddressResponse>> findAllClients(Pageable pageable) {

    Page<ClientPresenter.ClientAndAddressResponse> clients = findAllClientsUseCase.execute(pageable);

    return ResponseEntity.ok(new PagedModel<>(clients));
  }
}
