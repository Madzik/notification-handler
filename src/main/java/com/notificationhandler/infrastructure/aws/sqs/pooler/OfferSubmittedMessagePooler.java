package com.notificationhandler.infrastructure.aws.sqs.pooler;

import com.notificationhandler.infrastructure.aws.sqs.AwsMessagePooler;
import org.springframework.beans.factory.annotation.Value;

public class OfferSubmittedMessagePooler implements AwsMessagePooler {

    @Value("${aws.topic.offerSubmitted}")
    private String queueUrl;

    @Override
    public String getQueueUrl() {
        return this.queueUrl;
    }
}
