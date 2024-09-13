package com.salif.ecommerce.products.product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
    Integer id,
    @NotNull(message = "product name is required")
    String name,
    @NotNull(message = "pr")
    String description,
    double availableQuantity,
    BigDecimal price,
    Integer categoryId
) {
}
