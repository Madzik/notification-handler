package com.notificationhandler.infrastructure.aws.sqs.handler;

import org.springframework.stereotype.Service;

@Service
public class OfferAcceptedMessageHandler implements MessageHandler {

    public String getType() {
        return "offerAccepted";
    }

    public void handle(String messageType, String message) {

    }
}
