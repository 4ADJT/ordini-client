package io.ordini.clients.application;

import io.ordini.clients.adapter.mapper.ClientAddressMapper;
import io.ordini.clients.adapter.mapper.ClientMapper;
import io.ordini.clients.adapter.presenter.ClientAddressPresenter;
import io.ordini.clients.adapter.presenter.ClientPresenter;
import io.ordini.clients.domain.model.ClientModel;
import io.ordini.clients.domain.repository.IClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindAllClientsUseCase {

  private final IClientRepository repository;
  private final ClientMapper clientMapper;
  private final ClientAddressMapper clientAddressMapper;

  public Page<ClientPresenter.ClientAndAddressResponse> execute(Pageable pageable) {

    return repository.findAll(pageable).map(client -> {

      if (client == null) {
        return null;
      }

      ClientModel clientBuildModel = clientMapper.toModel(client);

      if (client.getAddress() == null) {
        return ClientPresenter.ClientAndAddressResponse.builder()
            .id(clientBuildModel.getId())
            .email(clientBuildModel.getEmail())
            .name(clientBuildModel.getName())
            .phone(clientBuildModel.getPhone())
            .cellphone(clientBuildModel.getCellphone())
            .document(clientBuildModel.getDocument())
            .address(null)
            .createdAt(clientBuildModel.getCreatedAt())
            .build();
      }

      ClientAddressPresenter.ClientAddressResponse addressBuildPresenter =
          ClientAddressPresenter.ClientAddressResponse.builder()
              .id(clientBuildModel.getAddress().getId())
              .clientId(clientBuildModel.getId())
              .street(clientBuildModel.getAddress().getStreet())
              .number(clientBuildModel.getAddress().getNumber())
              .complement(clientBuildModel.getAddress().getComplement())
              .neighborhood(clientBuildModel.getAddress().getNeighborhood())
              .city(clientBuildModel.getAddress().getCity())
              .state(clientBuildModel.getAddress().getState())
              .country(clientBuildModel.getAddress().getCountry())
              .zipCode(clientBuildModel.getAddress().getZipCode())
              .longitude(clientBuildModel.getAddress().getLongitude())
              .latitude(clientBuildModel.getAddress().getLatitude())
              .createdAt(clientBuildModel.getAddress().getCreatedAt())
              .build();

      return ClientPresenter.ClientAndAddressResponse.builder()
          .id(clientBuildModel.getId())
          .email(clientBuildModel.getEmail())
          .name(clientBuildModel.getName())
          .phone(clientBuildModel.getPhone())
          .cellphone(clientBuildModel.getCellphone())
          .address(addressBuildPresenter)
          .document(clientBuildModel.getDocument())
          .createdAt(clientBuildModel.getCreatedAt())
          .build();
    });

  }

}
