package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.client.ClientMapper;
import io.ordini.clients.adapter.presenter.dto.client.ClientPresenter;
import io.ordini.clients.domain.model.client.ClientModel;
import io.ordini.clients.domain.model.client.address.ClientAddressModel;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientUseCase {

  private final IClientRepository clientRepository;
  private final ClientMapper mapper;

  public ClientPresenter.ClientResponse execute(ClientPresenter.ClientRequest client) {

    ClientModel clientModel = ClientModel.builder()
        .email(client.email())
        .name(client.name())
        .phone(client.phone())
        .cellphone(client.cellphone())
        .documentCPF(client.document())
        .address((client.address() == null || client.address().city() == null ||
                client.address().state() == null ||
                client.address().country() == null ||
                client.address().street() == null ||
                client.address().zipCode() == null) ? null :
            ClientAddressModel.builder()
                .city(client.address().city())
                .state(client.address().state())
                .country(client.address().country())
                .complement(client.address().complement())
                .neighborhood(client.address().neighborhood())
                .number(client.address().number())
                .street(client.address().street())
                .zipCode(client.address().zipCode())
                .build())
        .createdAt(null)
        .build();

    ClientEntity clientToEntity = mapper.toEntity(clientModel);

    ClientEntity savedClient = clientRepository.create(clientToEntity);

    ClientModel model = mapper.toModel(savedClient);

    return ClientPresenter.ClientResponse.builder()
        .id(model.getId())
        .email(model.getEmail())
        .name(model.getName())
        .phone(model.getPhone())
        .cellphone(model.getCellphone())
        .document(model.getDocumentCPF())
        .address(
            ClientPresenter.ClientAddressResponse.builder()
                .id(model.getAddress().getId())
                .city(model.getAddress().getCity())
                .state(model.getAddress().getState())
                .country(model.getAddress().getCountry())
                .complement(model.getAddress().getComplement())
                .neighborhood(model.getAddress().getNeighborhood())
                .number(model.getAddress().getNumber())
                .street(model.getAddress().getStreet())
                .zipCode(model.getAddress().getZipCode())
                .build()
        )
        .createdAt(model.getCreatedAt())
        .build();
  }

}
