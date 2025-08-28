package com.notificationhandler.product.application.service;

import com.notificationhandler.configuration.exception.domain.model.ResourceNotFoundException;
import com.notificationhandler.product.application.dto.ProductToAdd;
import com.notificationhandler.product.domain.model.Product;
import com.notificationhandler.product.infrastructure.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findBy(Integer id) {
        return this.findAll().stream()
                .filter(product -> Objects.equals(product.getId(), id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Product not found."));
    }

    @Transactional
    public void add(ProductToAdd productToAdd) {
        boolean productExists = this.findAll().stream().anyMatch(product -> product.getName().equals(productToAdd.name()));

        if (productExists) {
            log.warn("Product with name {} already exists.", productToAdd.name());
            return;
        }
        Product product = new Product(productToAdd.name(), productToAdd.category());
        productRepository.save(product);
    }
}
