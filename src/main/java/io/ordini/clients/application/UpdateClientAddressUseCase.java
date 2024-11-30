package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.ClientAddressMapper;
import io.ordini.clients.adapter.presenter.ClientAddressPresenter;
import io.ordini.clients.domain.exception.ClientAddressNotExistsException;
import io.ordini.clients.domain.model.ClientAddressModel;
import io.ordini.clients.domain.repository.IClientAddressRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientAddressEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateClientAddressUseCase {

  private final IClientAddressRepository repository;
  private final ClientAddressMapper mapper;

  public ClientAddressPresenter.ClientAddressUpdateResponse execute(
      ClientAddressPresenter.ClientAddressUpdateRequest address
  ) {

    ClientAddressEntity addressExists = repository.findByClientId(address.clientId());

    if (addressExists == null) {
      throw new ClientAddressNotExistsException("Client address not exists for client id " + address.clientId() +
          ". Need to create first.", HttpStatus.BAD_REQUEST);
    }

    ClientAddressModel clientAddressModel = mapper.toModel(addressExists);
    clientAddressModel.setStreet(address.street());
    clientAddressModel.setNumber(address.number());
    clientAddressModel.setComplement(address.complement());
    clientAddressModel.setNeighborhood(address.neighborhood());
    clientAddressModel.setCity(address.city());
    clientAddressModel.setState(address.state());
    clientAddressModel.setCountry(address.country());
    clientAddressModel.setZipCode(address.zipCode());
    clientAddressModel.setLatitude(address.latitude());
    clientAddressModel.setLongitude(address.longitude());
    clientAddressModel.setCreatedAt(addressExists.getCreatedAt());

    clientAddressModel.validate();

    ClientAddressModel newClientAddress = mapper.toModel(repository.create(mapper.toEntity(clientAddressModel)));

    return ClientAddressPresenter.ClientAddressUpdateResponse.builder()
        .id(newClientAddress.getId())
        .clientId(newClientAddress.getClient().getId())
        .street(newClientAddress.getStreet())
        .number(newClientAddress.getNumber())
        .complement(newClientAddress.getComplement())
        .neighborhood(newClientAddress.getNeighborhood())
        .city(newClientAddress.getCity())
        .state(newClientAddress.getState())
        .country(newClientAddress.getCountry())
        .zipCode(newClientAddress.getZipCode())
        .latitude(newClientAddress.getLatitude())
        .longitude(newClientAddress.getLongitude())
        .createdAt(newClientAddress.getCreatedAt())
        .updatedAt(newClientAddress.getUpdatedAt())
        .build();
  }
}
