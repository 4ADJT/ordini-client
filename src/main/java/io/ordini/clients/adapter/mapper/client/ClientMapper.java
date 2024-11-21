package io.ordini.clients.adapter.mapper.client;

import io.ordini.clients.adapter.mapper.client.addess.AddressMapper;
import io.ordini.clients.adapter.presenter.dto.client.ClientInput;
import io.ordini.clients.domain.model.client.ClientModel;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface ClientMapper {

  ClientInput toInput(ClientModel clientModel);

  @Mapping(target = "id", ignore = true)
  @InheritConfiguration(name = "toInput")
  ClientModel toModel(ClientInput clientInput);

}
