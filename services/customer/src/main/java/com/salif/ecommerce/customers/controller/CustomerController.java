package com.salif.ecommerce.customers.controller;

import com.salif.ecommerce.customers.customer.CustomerRequest;
import com.salif.ecommerce.customers.customer.CustomerResponse;
import com.salif.ecommerce.customers.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.addCustomer(request));
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid CustomerRequest request){
        customerService.updateCustomer(request);
        return ResponseEntity.accepted()
                .body("Customer updated successfully");
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable("id") String id){
        return ResponseEntity.ok(customerService.existsById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
        return ResponseEntity.accepted().build();
    }

}
