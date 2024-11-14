package io.ordini.clients.adapter.gateway.db;

import io.ordini.clients.domain.model.ClientModel;
import io.ordini.clients.domain.repository.IClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class ClientRepositoryImpl implements IClientRepository {
  @Override
  public ClientModel save(ClientModel client) {
    return null;
  }

  @Override
  public UUID delete(ClientModel client) {
    return null;
  }

  @Override
  public ClientModel findById(String id) {
    return null;
  }

  @Override
  public ClientModel findByEmail(String email) {
    return null;
  }

  @Override
  public Page<ClientModel> findAll(Pageable pageable) {
    return null;
  }
}
