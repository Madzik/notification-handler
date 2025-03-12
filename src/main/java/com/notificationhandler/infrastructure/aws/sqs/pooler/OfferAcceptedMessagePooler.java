package com.notificationhandler.infrastructure.aws.sqs.pooler;

import com.notificationhandler.infrastructure.aws.sqs.AwsMessagePooler;
import org.springframework.beans.factory.annotation.Value;

public class OfferAcceptedMessagePooler implements AwsMessagePooler {

    @Value("${aws.topic.offerAccepted}")
    private String queueUrl;

    @Override
    public String getQueueUrl() {
        return this.queueUrl;
    }
}
