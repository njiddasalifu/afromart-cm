package com.salif.ecommerce.products.controller;

import com.salif.ecommerce.products.product.ProductPurchaseResponse;
import com.salif.ecommerce.products.product.ProductPurchaserequest;
import com.salif.ecommerce.products.product.ProductRequest;
import com.salif.ecommerce.products.product.ProductResponse;
import com.salif.ecommerce.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer> addProduct(
            @RequestBody @Valid ProductRequest request
    ){
        return ResponseEntity.ok(service.addProduct(request));
    }

    @PostMapping
    public ResponseEntity<List<ProductPurchaseResponse>> purcchaseProducts(
            @RequestBody List<ProductPurchaserequest> productPurchaserequests
    ){
        return ResponseEntity.ok(service.purchaseProducts(productPurchaserequests));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){ //TODO: add pagination
        return ResponseEntity.ok(service.findAll());
    }
}
