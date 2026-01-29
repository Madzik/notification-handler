package com.notificationhandler.notification.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.offer.domain.model.OfferSubmitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;

@Slf4j
@Service
public class OfferSubmittedAbstractNotificationSubscriber extends AbstractNotificationSubscriber {

    @Value("${aws.queue.offerSubmitted}")
    private String queueUrl;

    public OfferSubmittedAbstractNotificationSubscriber(SqsClient defaultSqsClient, ObjectMapper objectMapper) {
        super(defaultSqsClient, objectMapper);
    }

    @Override
    public String getQueueUrl() {
        return this.queueUrl;
    }

    @Override
    public void processMessage(Message message) {
        try {
            message.getValueForField("Message", OfferSubmitted.class).ifPresent(value ->
                    log.info("id" + value.getId()));

            JsonNode rootNode = super.objectMapper.readTree(message.body());
            String messageAsText = rootNode.get("Message").asText();
            JsonNode offerNode = objectMapper.readTree(messageAsText);
            String productCategory = offerNode.get("productCategory").asText();
            Integer productId = offerNode.get("id").asInt();
            log.info("Received offer for product: {}, id: {}", productCategory, productId);
        } catch (JsonProcessingException e) {
            log.error("Json parsing error {}", e.getMessage());
        }
    }
}
