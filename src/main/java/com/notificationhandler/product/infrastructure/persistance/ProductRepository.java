package com.notificationhandler.product.infrastructure.persistance;

import com.notificationhandler.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
