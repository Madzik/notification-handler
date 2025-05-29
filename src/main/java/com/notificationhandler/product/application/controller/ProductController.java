package com.notificationhandler.product.application.controller;

import com.notificationhandler.product.application.dto.ProductDetails;
import com.notificationhandler.product.application.dto.ProductToAdd;
import com.notificationhandler.product.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDetails> findAll() {
        return productService.findAll().stream().map(ProductDetails::new).toList();
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductToAdd productToAdd) {
        productService.add(productToAdd);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
