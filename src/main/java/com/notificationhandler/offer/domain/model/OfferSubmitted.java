package com.notificationhandler.offer.domain.model;

import com.notificationhandler.notification.application.domain.model.DomainEvent;
import com.notificationhandler.product.domain.model.ProductCategory;
import lombok.Getter;

@Getter
public class OfferSubmitted extends DomainEvent {
    private ProductCategory productCategory;

    public OfferSubmitted(Integer offerId, ProductCategory productCategory) {
        super(offerId);
        this.productCategory = productCategory;
    }
}
