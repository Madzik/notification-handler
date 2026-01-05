package com.notificationhandler.offer.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notificationhandler.infrastructure.aws.sns.NotificationPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;

@Service
public class OfferPublisher extends NotificationPublisher {

    @Value("${aws.topic.offerSubmitted}")
    private String topic;

    public OfferPublisher(SnsClient defaultSnsClient, ObjectMapper objectMapper) {
        super(defaultSnsClient, objectMapper);
    }

    @Override
    public String getTopic() {
        return topic;
    }
}
