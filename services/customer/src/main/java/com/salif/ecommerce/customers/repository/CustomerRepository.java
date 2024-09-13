package com.salif.ecommerce.customers.repository;


import com.salif.ecommerce.customers.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
