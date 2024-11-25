package io.ordini.clients.adapter.mapper.client;

import io.ordini.clients.domain.model.client.ClientAddressModel;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientAddressEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public interface ClientAddressMapper {

  ClientAddressModel toModel(ClientAddressEntity clientEntity);

  @InheritConfiguration
  ClientAddressEntity toEntity(ClientAddressModel clientModel);


}
