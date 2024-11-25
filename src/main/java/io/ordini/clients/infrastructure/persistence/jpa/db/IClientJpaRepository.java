package io.ordini.clients.infrastructure.persistence.jpa.db;

import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IClientJpaRepository extends JpaRepository<ClientEntity, UUID> {
    ClientEntity findByEmail(String email);
    ClientEntity findByDocument(String document);
}
