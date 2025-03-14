package com.notificationhandler.infrastructure.aws.sqs.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.notification.application.dto.OfferAccepted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferAcceptedMessageHandler implements MessageHandler {

    private final ObjectMapper objectMapper;

    public String getType() {
        return "offerAccepted";
    }

    public void handle(String messageType, String message) throws JsonProcessingException {
        OfferAccepted offerAccepted = objectMapper.readValue(message, OfferAccepted.class);
    }
}
