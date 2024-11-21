package io.ordini.clients.adapter.presenter.dto.client;

import io.ordini.clients.adapter.presenter.dto.client.address.AddressInput;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ClientInput(

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    String name,

    @Email(message = "Email is invalid")
    String email,

    String phone,

    String cellphone,

    @NotEmpty(message = "Document is required")
    @NotNull(message = "Document is required")
    String document,

    @NotEmpty(message = "Address is required")
    @NotNull(message = "Address is required")
    AddressInput address

) {

}
