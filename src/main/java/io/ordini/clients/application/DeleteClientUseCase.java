package io.ordini.clients.application;

import io.ordini.clients.domain.exception.ClientNotFoundException;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteClientUseCase {
  public final IClientRepository repository;

  public UUID execute(UUID clientId) {
    Optional<ClientEntity> client = repository.findById(clientId);

    if (client.isEmpty()) {
      throw new ClientNotFoundException("Client not found", HttpStatus.BAD_REQUEST);
    }

    return repository.delete(client.get().getId());
  }

}
