package com.notificationhandler.product.application.dto;

import com.notificationhandler.product.domain.model.Product;
import com.notificationhandler.product.domain.model.ProductCategory;

public record ProductDetails(Integer id, String name, ProductCategory category) {
    public ProductDetails(Product product) {
        this(product.getId(), product.getName(), product.getCategory());
    }
}
