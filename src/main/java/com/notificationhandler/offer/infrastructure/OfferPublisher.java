package com.notificationhandler.offer.infrastructure;

import com.notificationhandler.infrastructure.aws.sns.NotificationPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;

@Service
public class OfferPublisher extends NotificationPublisher {

    @Value("${aws.topic.offerSubmitted}")
    private String topic;

    public OfferPublisher(SnsClient defaultSnsClient) {
        super(defaultSnsClient);
    }

    @Override
    public String getTopic() {
        return topic;
    }
}
