package io.ordini.clients.domain.model.client;

import io.ordini.clients.domain.model.client.address.ClientAddressModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientModel {

  private UUID id;
  private String name;
  private String email;
  private String phone;
  private String cellphone;
  private String documentCPF;
  private ClientAddressModel address;
  private LocalDateTime createdAt;

}
