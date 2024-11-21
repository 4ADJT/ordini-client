package io.ordini.clients.adapter.presenter.dto.client;

import io.ordini.clients.adapter.presenter.dto.client.address.AddressOutput;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientOutput(
    UUID id,
    String name,
    String email,
    String phone,
    String cellphone,
    String document,
    AddressOutput address,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
}
