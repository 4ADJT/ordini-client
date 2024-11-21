package io.ordini.clients.adapter.presenter.dto.client.address;

public record AddressInput(
    String street,
    int number,
    String complement,
    String neighborhood,
    String city,
    String state,
    String country,
    String zipCode
) {

}
