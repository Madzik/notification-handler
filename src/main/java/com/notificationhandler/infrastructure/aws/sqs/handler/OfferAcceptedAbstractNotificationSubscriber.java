package com.notificationhandler.infrastructure.aws.sqs.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.notification.application.dto.OfferAccepted;
import com.notificationhandler.notification.infrastructure.AbstractNotificationSubscriber;
import com.notificationhandler.offer.application.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;

@Slf4j
@Service
public class OfferAcceptedAbstractNotificationSubscriber extends AbstractNotificationSubscriber {

    @Value("${aws.queue.offerAccepted}")
    private String queueUrl;

    private OfferService offerService;

    public OfferAcceptedAbstractNotificationSubscriber(SqsClient defaultSqsClient, ObjectMapper objectMapper,
                                                       OfferService offerService) {
        super(defaultSqsClient, objectMapper);
        this.offerService = offerService;
    }

    @Override
    public String getQueueUrl() {
        return this.queueUrl;
    }

    @Override
    public void processMessage(Message message) {
        try {
            message.getValueForField("Message", OfferAccepted.class).ifPresent(value ->
                    log.info("id" + value.getId()));

            JsonNode rootNode = super.objectMapper.readTree(message.body());
            String messageAsText = rootNode.get("Message").asText();
            JsonNode offerAcceptedNode = objectMapper.readTree(messageAsText);
            Integer productAcceptedId = offerAcceptedNode.get("productAcceptedId").asInt();
            offerService.reserveOffer(productAcceptedId);
            log.info("Accepted product offer id: {}", productAcceptedId);
        } catch (JsonProcessingException e) {
            log.error("Json parsing error {}", e.getMessage());
        }
    }
}
