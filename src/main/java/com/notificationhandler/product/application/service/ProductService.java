package com.notificationhandler.product.application.service;

import com.notificationhandler.product.application.dto.ProductToAdd;
import com.notificationhandler.product.domain.model.Product;
import com.notificationhandler.product.infrastructure.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void add(ProductToAdd productToAdd) {
        Product product = new Product(productToAdd.name(), productToAdd.category());
        productRepository.save(product);
    }
}
