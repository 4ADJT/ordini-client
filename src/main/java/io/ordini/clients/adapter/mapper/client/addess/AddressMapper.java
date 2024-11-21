package io.ordini.clients.adapter.mapper.client.addess;

import io.ordini.clients.adapter.presenter.dto.client.address.AddressInput;
import io.ordini.clients.domain.model.client.address.AddressModel;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  AddressInput toInput(AddressModel addressModel);

  @InheritConfiguration(name = "toInput")
  @Mapping(target = "id", ignore = true)
  AddressModel toModel(AddressInput addressInput);

}
