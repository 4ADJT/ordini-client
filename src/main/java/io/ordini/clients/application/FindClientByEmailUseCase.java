package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.ClientAddressMapper;
import io.ordini.clients.adapter.mapper.ClientMapper;
import io.ordini.clients.adapter.presenter.ClientAddressPresenter;
import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.domain.exception.ClientNotFoundException;
import io.ordini.clients.domain.model.ClientModel;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindClientByEmailUseCase {

  private final IClientRepository repository;
  private final ClientMapper clientMapper;
  private final ClientAddressMapper clientAddressMapper;

  public ClientPresenter.ClientAndAddressResponse execute(String email) {

    ClientEntity clientByEmail = repository.findByEmail(email);

    if (clientByEmail == null) {
      throw new ClientNotFoundException("Client not found", HttpStatus.BAD_REQUEST);
    }

    ClientModel model = clientMapper.toModel(clientByEmail);

    if(model.getAddress() == null) {
      return ClientPresenter.ClientAndAddressResponse.builder()
          .id(model.getId())
          .email(model.getEmail())
          .name(model.getName())
          .phone(model.getPhone())
          .cellphone(model.getCellphone())
          .address(null)
          .document(model.getDocument())
          .createdAt(model.getCreatedAt())
          .build();
    }

    ClientAddressPresenter.ClientAddressResponse addressBuildPresenter = ClientAddressPresenter.ClientAddressResponse.builder()
        .id(model.getAddress().getId())
        .clientId(model.getId())
        .street(model.getAddress().getStreet())
        .number(model.getAddress().getNumber())
        .complement(model.getAddress().getComplement())
        .neighborhood(model.getAddress().getNeighborhood())
        .city(model.getAddress().getCity())
        .state(model.getAddress().getState())
        .country(model.getAddress().getCountry())
        .zipCode(model.getAddress().getZipCode())
        .longitude(model.getAddress().getLongitude())
        .latitude(model.getAddress().getLatitude())
        .createdAt(model.getAddress().getCreatedAt())
        .build();


    return ClientPresenter.ClientAndAddressResponse.builder()
        .id(model.getId())
        .email(model.getEmail())
        .name(model.getName())
        .phone(model.getPhone())
        .cellphone(model.getCellphone())
        .address(addressBuildPresenter)
        .document(model.getDocument())
        .createdAt(model.getCreatedAt())
        .build();

  }

}
