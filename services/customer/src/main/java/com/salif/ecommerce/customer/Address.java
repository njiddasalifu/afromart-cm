package com.salif.ecommerce.customer;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Address {
    private String id;
    private String street;
    private String houseNumber;
    private String zipCode;
}
