package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.ClientMapper;
import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.domain.exception.ClientAlreadyExistsException;
import io.ordini.clients.domain.model.ClientModel;
import io.ordini.clients.domain.repository.IClientRepository;
import io.ordini.clients.infrastructure.persistence.jpa.entity.ClientEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientUseCase {

  private final IClientRepository repository;
  private final ClientMapper mapper;

  public ClientPresenter.ClientResponse execute(ClientPresenter.ClientRequest client) {

    ClientModel validate = new ClientModel();

    validate.validateCPF(client.document());
    validate.validateEmail(client.email());

    if (repository.findByEmail(client.email()) != null || repository.findByDocument(client.document()) != null) {
      throw new ClientAlreadyExistsException("Client already exists", HttpStatus.BAD_REQUEST);
    }

    ClientModel clientModel = ClientModel
        .builder()
        .email(client.email())
        .name(client.name())
        .phone(client.phone())
        .cellphone(client.cellphone())
        .document(client.document())
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
