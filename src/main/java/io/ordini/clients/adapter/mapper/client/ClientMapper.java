package io.ordini.clients.adapter.mapper.client;

import io.ordini.clients.domain.model.client.ClientModel;
import io.ordini.clients.domain.model.client.address.ClientAddressModel;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.address.ClientAddressEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientAddressEntity.class, ClientAddressModel.class})
public interface ClientMapper {

    @Mapping(source = "document", target = "documentCPF")
    ClientModel toModel(ClientEntity entity);

    @InheritConfiguration
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "documentCPF", target = "document")
    ClientEntity toEntity(ClientModel model);

}
