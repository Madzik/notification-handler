package com.notificationhandler.notification.application.dto;

import com.notificationhandler.notification.application.domain.model.DomainEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferSubmitted extends DomainEvent {
    private Integer offerID;
}
