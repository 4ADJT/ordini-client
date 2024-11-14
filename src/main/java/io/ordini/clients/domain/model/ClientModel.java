package io.ordini.clients.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ClientModel {
  private UUID id;
  private String name;
  private String email;
  private String phone;
  private String cellphone;
  private String document;
  private Address address;

  @Getter
  @Builder
  public static class Address {
    private String street;
    private int number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;
  }

}
