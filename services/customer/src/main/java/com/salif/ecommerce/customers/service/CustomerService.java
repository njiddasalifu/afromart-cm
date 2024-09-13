package com.salif.ecommerce.customers.service;

import com.salif.ecommerce.customers.customer.Customer;
import com.salif.ecommerce.customers.customer.CustomerRequest;
import com.salif.ecommerce.customers.customer.CustomerResponse;
import com.salif.ecommerce.customers.exceptions.CustomerNotFoundException;
import com.salif.ecommerce.customers.mapper.CustomerMapper;
import com.salif.ecommerce.customers.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public String addCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: No customer with ID::%s ", request.id(), " found!.")
                ));
        mergeCustomer(customer, request);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())){
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if (request.address() != null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String id) {
        return customerRepository.findById(id)
                .isPresent();   //if customer with the provided id is present
    }


    public CustomerResponse findById(String id) {
        return customerRepository.findById(id)
                .map(customerMapper::fromCustomer)
                .orElseThrow(()-> new CustomerNotFoundException(format("Not customer with Id found %s", id)));
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
