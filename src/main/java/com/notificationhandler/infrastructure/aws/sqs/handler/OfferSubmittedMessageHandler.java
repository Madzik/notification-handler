package com.notificationhandler.infrastructure.aws.sqs.handler;

import org.springframework.stereotype.Service;

@Service
public class OfferSubmittedMessageHandler implements MessageHandler {

    public String getType() {
        return "offerSubmitted";
    }

    public void handle(String messageType, String message) {

    }
}
