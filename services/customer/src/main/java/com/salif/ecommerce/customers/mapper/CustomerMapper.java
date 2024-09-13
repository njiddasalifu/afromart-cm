package com.salif.ecommerce.customers.mapper;

import com.salif.ecommerce.customers.customer.Customer;
import com.salif.ecommerce.customers.customer.CustomerRequest;
import com.salif.ecommerce.customers.customer.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if (request == null)
            return null;  //here we are doing a null check
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
