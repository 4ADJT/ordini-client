package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.ClientAddressMapper;
import io.ordini.clients.adapter.mapper.ClientMapper;
import io.ordini.clients.adapter.presenter.ClientAddressPresenter;
import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.domain.exception.ClientNotFoundException;
import io.ordini.clients.domain.model.ClientAddressModel;
import io.ordini.clients.domain.model.ClientModel;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindClientByDocumentUseCase {

  private final IClientRepository repository;
  private final ClientMapper clientMapper;
  private final ClientAddressMapper clientAddressMapper;

  public ClientPresenter.ClientAndAddressResponse execute(String document) {

    ClientEntity clientByDocument = repository.findByDocument(document);

    if (clientByDocument == null) {
      throw new ClientNotFoundException("Client not found", HttpStatus.BAD_REQUEST);
    }

    ClientModel model = clientMapper.toModel(clientByDocument);

    if(clientByDocument.getAddress() == null){

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
    } else {
      ClientAddressModel addressModel = clientAddressMapper.toModel(clientByDocument.getAddress());

      ClientAddressPresenter.ClientAddressResponse addressBuildPresenter = ClientAddressPresenter.ClientAddressResponse.builder()
          .id(addressModel.getId())
          .street(addressModel.getStreet())
          .number(addressModel.getNumber())
          .complement(addressModel.getComplement())
          .neighborhood(addressModel.getNeighborhood())
          .city(addressModel.getCity())
          .state(addressModel.getState())
          .country(addressModel.getCountry())
          .zipCode(addressModel.getZipCode())
          .longitude(addressModel.getLongitude())
          .latitude(addressModel.getLatitude())
          .createdAt(addressModel.getCreatedAt())
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

}
