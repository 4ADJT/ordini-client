package io.ordini.clients.domain.repository;

import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface IClientRepository {
  ClientEntity create(ClientEntity client);
  ClientEntity update(ClientEntity client);
  UUID delete(UUID clientId);
  Optional<ClientEntity> findById(UUID id);
  ClientEntity findByEmail(String email);
  ClientEntity findByDocument(String document);
  Page<ClientEntity> findAll(Pageable pageable);
}
