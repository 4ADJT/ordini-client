package io.ordini.clients.adapter.gateway.db;

import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.db.IClientJpaRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
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
  public ClientEntity create(ClientEntity client) {
    return clientJpaRepository.save(client);
  }

  @Override
  public UUID delete(ClientEntity client) {
    return null;
  }

  @Override
  public ClientEntity findById(String id) {
    return null;
  }

  @Override
  public ClientEntity findByEmail(String email) {
    return null;
  }

  @Override
  public Page<ClientEntity> findAll(Pageable pageable) {
    return null;
  }
}
