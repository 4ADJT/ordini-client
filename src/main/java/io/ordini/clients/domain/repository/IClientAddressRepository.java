package io.ordini.clients.domain.repository;

import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientAddressEntity;

import java.util.UUID;

public interface IClientAddressRepository {
  ClientAddressEntity create(ClientAddressEntity clientAddress);
  ClientAddressEntity findByClientId(UUID clientId);
  ClientAddressEntity update(ClientAddressEntity clientAddress);
}
