package io.ordini.clients.domain.repository;

import io.ordini.clients.domain.model.client.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IClientRepository {
  ClientModel save(ClientModel client);
  UUID delete(ClientModel client);
  ClientModel findById(String id);
  ClientModel findByEmail(String email);
  Page<ClientModel> findAll(Pageable pageable);
}
