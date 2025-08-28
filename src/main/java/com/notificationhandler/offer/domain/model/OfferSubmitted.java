package com.notificationhandler.offer.domain.model;

import com.notificationhandler.notification.application.domain.model.DomainEvent;

public class OfferSubmitted extends DomainEvent {

    public OfferSubmitted(Integer offerId) {
        super(offerId);
    }
}
