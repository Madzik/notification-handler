package com.notificationhandler.product.application.service;

import com.notificationhandler.product.domain.model.Product;
import com.notificationhandler.product.infrastructure.persistance.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository offerRepository;

    public List<Product> findAll() {
        return offerRepository.findAll();
    }
}
