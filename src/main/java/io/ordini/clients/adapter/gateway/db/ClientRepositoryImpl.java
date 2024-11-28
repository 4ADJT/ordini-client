package io.ordini.clients.adapter.gateway.db;

import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.db.IClientJpaRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements IClientRepository {
  public final IClientJpaRepository repository;

  @Override
  public ClientEntity create(ClientEntity client) {
    return repository.save(client);
  }

  @Override
  public ClientEntity update(ClientEntity client) {
    if (repository.existsById(client.getId())) {
      return repository.saveAndFlush(client);
    }

    return null;
  }

  @Override
  public UUID delete(UUID clientId) {

    Optional<ClientEntity> client = this.findById(clientId);

    if (client.isPresent()) {
      repository.deleteById(clientId);
      return client.get().getId();
    }
    return null;

  }

  @Override
  public Optional<ClientEntity> findById(UUID id) {
    return repository.findById(id);
  }

  @Override
  public ClientEntity findByEmail(String email) {
    return repository.findByEmail(email);
  }

  @Override
  public ClientEntity findByDocument(String document) {
    return repository.findByDocument(document);
  }

  @Override
  public Page<ClientEntity> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
