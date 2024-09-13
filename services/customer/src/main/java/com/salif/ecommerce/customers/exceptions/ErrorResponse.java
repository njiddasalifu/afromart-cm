package com.salif.ecommerce.customers.exceptions;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
