package com.notificationhandler.infrastructure.aws.sqs.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.offer.domain.model.OfferSubmitted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferSubmittedMessageHandler implements MessageHandler {

    private final ObjectMapper objectMapper;

    public String getType() {
        return "offerSubmitted";
    }

    public void handle(String messageType, String message) throws JsonProcessingException {
        OfferSubmitted offerSubmitted = objectMapper.readValue(message, OfferSubmitted.class);
    }
}
