package com.notificationhandler.notification.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.notification.application.domain.model.NotificationSubscriber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SqsException;

@Slf4j
@Service
@RequiredArgsConstructor
public abstract class AbstractNotificationSubscriber implements NotificationSubscriber {

    protected final SqsClient defaultSqsClient;
    protected final ObjectMapper objectMapper;

    public abstract String getQueueUrl();

    public abstract void processMessage(Message message);

    public void consumeMessage() {
        try {
            ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                    .queueUrl(getQueueUrl())
                    .build();

            ReceiveMessageResponse response = defaultSqsClient.receiveMessage(request);

            if (!response.hasMessages()) {
                log.info("No messages in the queue");
                return;
            }

            response.messages().forEach(this::processMessage);
        } catch (SqsException exception) {
            log.error("Receive message response exception {} ", exception.getMessage());
        }
    }
}
