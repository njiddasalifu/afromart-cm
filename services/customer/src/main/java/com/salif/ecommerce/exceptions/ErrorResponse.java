package com.salif.ecommerce.exceptions;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
