package io.ordini.clients.infrastructure.persistence.jpa.db;

import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IClientAddressJpaRepository extends JpaRepository<ClientAddressEntity, UUID> {

  ClientAddressEntity findByClientId(UUID clientId);

}
