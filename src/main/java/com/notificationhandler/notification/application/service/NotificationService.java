package com.notificationhandler.notification.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final SnsClient defaultSnsClient;

    @Value("${aws.topic}")
    private final String topic;

    public void publishMessage(String message) {
        try {
            PublishRequest publishRequest = PublishRequest.builder()
                    .message(message)
                    .topicArn(topic)
                    .build();

            PublishResponse publishResponse = defaultSnsClient.publish(publishRequest);
            log.info("Publish response id {} ", publishResponse.messageId());
        } catch (SnsException exception) {
            log.error("Publish request exception {} ", exception.getMessage());
        }
    }
}
