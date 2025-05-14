package com.notificationhandler.offer.application.service;

import com.notificationhandler.notification.application.service.NotificationPublisher;
import com.notificationhandler.offer.application.dto.OfferSubmitted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final NotificationPublisher notificationPublisher;

    public void submitOffer(OfferSubmitted offerSubmitted) {
        notificationPublisher.publishMessage(offerSubmitted.getOfferID().toString());
    }
}
