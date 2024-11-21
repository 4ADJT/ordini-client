package io.ordini.clients.adapter.gateway.db;

import io.ordini.clients.domain.model.client.ClientModel;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.db.IClientJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements IClientRepository {
  public final IClientJpaRepository clientJpaRepository;

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
