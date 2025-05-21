package com.notificationhandler.offer.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @ManyToOne
    @JoinColumn(name = "productId")
    @Column(nullable = false)
    private Product product;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unitOfMeasurement;

    @Column(nullable = false)
    private String unitType;

    @Column(nullable = false)
    private Double units;

    protected Offer() {
    }

    public Offer(Product product, UnitOfMeasurement unitOfMeasurement, String unitType, Double units) {
        this.product = product;
        this.unitOfMeasurement = unitOfMeasurement;
        this.unitType = unitType;
        this.units = units;
    }

}
