package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.ClientAddressMapper;
import io.ordini.clients.adapter.mapper.ClientMapper;
import io.ordini.clients.adapter.presenter.ClientAddressPresenter;
import io.ordini.clients.domain.exception.ClientAddressAlreadyCreatedException;
import io.ordini.clients.domain.exception.ClientNotFoundException;
import io.ordini.clients.domain.model.ClientAddressModel;
import io.ordini.clients.domain.model.ClientModel;
import io.ordini.clients.domain.repository.IClientAddressRepository;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientAddressEntity;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateClientAddressUseCase {

  private final IClientAddressRepository repository;
  private final IClientRepository clientRepository;
  private final ClientAddressMapper mapper;
  private final ClientMapper clientMapper;

  public ClientAddressPresenter.ClientAddressResponse execute(
      UUID clientId,
      ClientAddressPresenter.ClientAddressRequest address
  ) {

    Optional<ClientEntity> clientById = clientRepository.findById(clientId);

    if (clientById.isEmpty()) {
      throw new ClientNotFoundException("Client not found", HttpStatus.BAD_REQUEST);
    }

    ClientAddressEntity addressExists = repository.findByClientId(clientById.get().getId());

    if (addressExists != null) {
      throw new ClientAddressAlreadyCreatedException("Client already has an address", HttpStatus.BAD_REQUEST);
    }

    ClientModel clientModel = clientMapper.toModel(clientById.get());

    ClientAddressModel addressModel = ClientAddressModel
        .builder()
        .street(address.street())
        .number(address.number())
        .complement(address.complement())
        .neighborhood(address.neighborhood())
        .city(address.city())
        .state(address.state())
        .country(address.country())
        .zipCode(address.zipCode())
        .latitude(address.latitude())
        .longitude(address.longitude())
        .client(clientModel)
        .build();

    addressModel.validate();

    ClientAddressEntity clientAddressEntity = mapper.toEntity(addressModel);

    ClientAddressModel newClientAddress = mapper.toModel(repository.create(clientAddressEntity));

    return ClientAddressPresenter.ClientAddressResponse.builder()
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
        .build();
  }

}
