package io.ordini.clients.domain.model.client;

import io.ordini.clients.domain.model.client.address.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {

  private UUID id;
  private String name;
  private String email;
  private String phone;
  private String cellphone;
  private String document;
  private AddressModel address;

}
