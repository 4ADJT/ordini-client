package io.ordini.clients.adapter.presenter.dto.client.address;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddressInput(

    @NotNull(message = "Street is required")
    @NotEmpty(message = "Street is required")
    String street,

    int number,

    String complement,

    @NotNull(message = "Neighborhood is required")
    @NotEmpty(message = "Neighborhood is required")
    String neighborhood,

    @NotNull(message = "City is required")
    @NotEmpty(message = "City is required")
    String city,

    @NotNull(message = "State is required")
    @NotEmpty(message = "State is required")
    String state,

    @NotNull(message = "Country is required")
    @NotEmpty(message = "Country is required")
    String country,

    @NotNull(message = "Zip code is required")
    @NotEmpty(message = "Zip code is required")
    String zipCode

) {

}
