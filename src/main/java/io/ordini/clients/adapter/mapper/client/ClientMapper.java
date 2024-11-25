package io.ordini.clients.adapter.mapper.client;

import io.ordini.clients.domain.model.client.ClientModel;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientModel toModel(ClientEntity entity);

    @InheritConfiguration
    ClientEntity toEntity(ClientModel model);

}
