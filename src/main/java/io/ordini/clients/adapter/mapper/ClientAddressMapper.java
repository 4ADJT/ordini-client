package io.ordini.clients.adapter.mapper;

import io.ordini.clients.domain.model.ClientAddressModel;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public interface ClientAddressMapper {

  @Mapping(target = "client.address", ignore = true)
  ClientAddressModel toModel(ClientAddressEntity clientEntity);

  @Mapping(target = "client.address", ignore = true)
  ClientAddressEntity toEntity(ClientAddressModel clientModel);


}
