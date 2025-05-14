package com.notificationhandler.infrastructure.aws.sns;

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

    public abstract String getTopic();
}
