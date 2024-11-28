package io.ordini.clients.adapter.gateway.db;

import io.ordini.clients.domain.repository.IClientAddressRepository;
import io.ordini.clients.infrastructure.persistence.jpa.db.IClientAddressJpaRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientAddressEntity;
import lombok.AllArgsConstructor;
import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@AllArgsConstructor
public class ClientAddressRepositoryImpl implements IClientAddressRepository {
  public final IClientAddressJpaRepository repository;

  @Override
  public ClientAddressEntity create(ClientAddressEntity clientAddress)
      throws IllegalQueryOperationException {
    try {
      return repository.save(clientAddress);
    } catch (Exception e) {
      throw new IllegalQueryOperationException("Error creating client address.");
    }
  }

  @Override
  public ClientAddressEntity findByClientId(UUID clientId) {
    return repository.findByClientId(clientId);
  }

  @Override
  public ClientAddressEntity update(ClientAddressEntity clientAddress) {
    if (clientAddress.getId() != null) {
      return repository.saveAndFlush(clientAddress);
    }

    throw new IllegalQueryOperationException("Client address id is required.");
  }
}
