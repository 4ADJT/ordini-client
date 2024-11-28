package io.ordini.clients.adapter.mapper;

import io.ordini.clients.domain.model.ClientModel;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ClientAddressMapper.class)
public interface ClientMapper {

    ClientModel toModel(ClientEntity entity);

    @InheritConfiguration
    ClientEntity toEntity(ClientModel model);

}
