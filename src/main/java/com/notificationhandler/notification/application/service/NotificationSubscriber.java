package com.notificationhandler.notification.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.offer.domain.model.OfferSubmitted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SqsException;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationSubscriber {

    private final SqsClient defaultSqsClient;
    private final ObjectMapper objectMapper;

    @Value("${aws.queue.offerSubmitted}")
    private String queueUrl;

    public void consumeMessage() throws Exception {
        try {
            ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .build();

            ReceiveMessageResponse response = defaultSqsClient.receiveMessage(request);

            if (!response.hasMessages()) {
                log.info("No messages in the queue");
                return;
            }

            response.messages().forEach(message -> {
                try {
                    message.getValueForField("Message", OfferSubmitted.class).ifPresent(value ->
                            log.info("id" + value.getId()));

                    JsonNode rootNode = objectMapper.readTree(message.body());
                    String messageAsText = rootNode.get("Message").asText();
                    JsonNode offerNode = objectMapper.readTree(messageAsText);
                    String productCategory = offerNode.get("productCategory").asText();
                    Integer productId = offerNode.get("id").asInt();

                    log.info("Received offer for product: {}, id: {}", productCategory, productId);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (SqsException exception) {
            log.error("Receive message response exception {} ", exception.getMessage());
            throw new Exception("Sqs exception");
        }
    }
}
