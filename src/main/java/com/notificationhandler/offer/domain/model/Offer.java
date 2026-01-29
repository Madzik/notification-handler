package com.notificationhandler.offer.domain.model;

import com.notificationhandler.product.domain.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "unit_of_measurements", nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unitOfMeasurement;

    @Column(nullable = false)
    private Double units;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    protected Offer() {
    }

    public Offer(Product product, UnitOfMeasurement unitOfMeasurement, Double units, OfferStatus status) {
        this.product = product;
        this.unitOfMeasurement = unitOfMeasurement;
        this.status = status;
        this.units = units;
    }

    public void reserve() {
        this.status = OfferStatus.RESERVED;
    }

}
