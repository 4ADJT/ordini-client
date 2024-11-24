package io.ordini.clients.domain.repository;

import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IClientRepository {
  ClientEntity create(ClientEntity client);
  UUID delete(ClientEntity client);
  ClientEntity findById(String id);
  ClientEntity findByEmail(String email);
  Page<ClientEntity> findAll(Pageable pageable);
}
