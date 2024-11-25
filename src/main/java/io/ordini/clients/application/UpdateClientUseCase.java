package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.client.ClientMapper;
import io.ordini.clients.adapter.presenter.client.ClientPresenter;
import io.ordini.clients.domain.model.client.ClientModel;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.client.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateClientUseCase {
  public final IClientRepository repository;
  public final ClientMapper mapper;

  public ClientPresenter.ClientResponse execute(ClientPresenter.ClientUpdateRequest client) {

    ClientEntity clientEntity = repository.findById(client.id()).orElse(null);

    if(clientEntity == null) {
      throw new RuntimeException("Client not found");
    }

    ClientModel validate = new ClientModel();

    validate.validateCPF(client.document());
    validate.validateEmail(client.email());

    ClientModel clientModel = ClientModel
        .builder()
        .email(client.email())
        .name(client.name())
        .phone(client.phone())
        .cellphone(client.cellphone())
        .document(client.document())
        .createdAt(clientEntity.getCreatedAt())
        .build();

    ClientEntity clientToEntity = mapper.toEntity(clientModel);

    ClientEntity savedClient = repository.create(clientToEntity);

    ClientModel model = mapper.toModel(savedClient);

    return ClientPresenter.ClientResponse.builder()
        .id(model.getId())
        .email(model.getEmail())
        .name(model.getName())
        .phone(model.getPhone())
        .cellphone(model.getCellphone())
        .document(model.getDocument())
        .createdAt(model.getCreatedAt())
        .build();
  }

}
