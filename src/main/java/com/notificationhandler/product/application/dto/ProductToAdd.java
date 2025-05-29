package com.notificationhandler.product.application.dto;

import com.notificationhandler.product.domain.model.ProductCategory;

public record ProductToAdd(String name, ProductCategory category) {
}
