package com.notificationhandler.notification.application.service;

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

    @Value("${aws.queue.url}")
    private String queueUrl;

    public String consumeMessage() {
        try {
            ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .build();

            ReceiveMessageResponse response = defaultSqsClient.receiveMessage(request);
            StringBuilder sb = new StringBuilder();
            response.messages().forEach(message -> {
                log.info("Received message id {} ", message.messageId());
                log.info("Message body {} ", message.body());
                sb.append(message.body());
            });
            return sb.toString();
        } catch (SqsException exception) {
            log.error("Receive message response exception {} ", exception.getMessage());
            return "";
        }
    }
}
