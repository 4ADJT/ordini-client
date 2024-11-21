package io.ordini.clients.adapter.presenter.dto.client.address;

import java.time.LocalDateTime;
import java.util.UUID;

public record AddressOutput(
    UUID id,
    String street,
    int number,
    String complement,
    String neighborhood,
    String city,
    String state,
    String country,
    String zipCode,
    LocalDateTime created_at,
    LocalDateTime  updated_at
) {
}
