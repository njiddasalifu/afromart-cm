package com.salif.ecommerce.customers.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer firstname is required")
        String firstname,
        @NotNull(message = "customer lastname is required")
        String lastname,
        @Email(message = "email is not valid")
        String email,
        Address address
) {
}
