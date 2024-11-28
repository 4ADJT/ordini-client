package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.ClientMapper;
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
public class UpdateClientUseCase {
  public final IClientRepository repository;
  public final ClientMapper mapper;

  public ClientPresenter.ClientResponse execute(ClientPresenter.ClientUpdateRequest client) {

    ClientEntity clientEntity = repository.findById(client.id()).orElse(null);

    if(clientEntity == null) {
      throw new ClientNotFoundException("Client not found", HttpStatus.BAD_REQUEST);
    }

    ClientModel clientModel = ClientModel
        .builder()
        .id(clientEntity.getId())
        .email(clientEntity.getEmail())
        .name(client.name())
        .phone(client.phone() == null ? clientEntity.getPhone() : client.phone())
        .cellphone(client.cellphone() == null ? clientEntity.getCellphone() : client.cellphone())
        .document(clientEntity.getDocument())
        .createdAt(clientEntity.getCreatedAt())
        .build();

    ClientEntity clientToEntity = mapper.toEntity(clientModel);

    ClientEntity savedClient = repository.update(clientToEntity);

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
