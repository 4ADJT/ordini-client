package io.ordini.clients.adapter.mapper;

import io.ordini.clients.domain.model.ClientAddressModel;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientAddressEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public interface ClientAddressMapper {

  ClientAddressModel toModel(ClientAddressEntity clientEntity);

  @InheritConfiguration
  ClientAddressEntity toEntity(ClientAddressModel clientModel);


}
