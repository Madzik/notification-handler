package com.notificationhandler.infrastructure.aws.sns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.notification.application.domain.model.DomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

@Slf4j
@Service
@RequiredArgsConstructor
public abstract class NotificationPublisher {

    private final SnsClient defaultSnsClient;
    private final ObjectMapper objectMapper;

    public void publishMessage(String message) {
        try {
            PublishRequest publishRequest = PublishRequest.builder()
                    .message(message)
                    .topicArn(getTopic())
                    .build();

            PublishResponse publishResponse = defaultSnsClient.publish(publishRequest);
            log.info("Publish response id {} ", publishResponse.messageId());
        } catch (SnsException exception) {
            log.error("Publish request exception {} ", exception.getMessage());
        }
    }

    public void publishMessage(DomainEvent domainEvent) {
        try {
            PublishRequest publishRequest = PublishRequest.builder()
                    .message(objectMapper.writeValueAsString(domainEvent))
                    .topicArn(getTopic())
                    .build();

            PublishResponse publishResponse = defaultSnsClient.publish(publishRequest);
            log.info("Publish response id {} ", publishResponse.messageId());
        } catch (SnsException exception) {
            log.error("Publish request exception {} ", exception.getMessage());
        } catch (JsonProcessingException exception) {
            log.error("Parsing exception {} ", exception.getMessage());
        }
    }

    public abstract String getTopic();
}
