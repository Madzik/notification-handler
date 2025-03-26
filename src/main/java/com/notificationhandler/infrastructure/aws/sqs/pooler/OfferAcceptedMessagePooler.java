package com.notificationhandler.infrastructure.aws.sqs.pooler;

import com.notificationhandler.infrastructure.aws.sqs.AwsMessagePooler;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.services.sqs.SqsClient;

public class OfferAcceptedMessagePooler extends DefaultAwsMessagePooler implements AwsMessagePooler {

    @Value("${aws.topic.offerAccepted}")
    private String queueUrl;

    public OfferAcceptedMessagePooler(SqsClient defaultSqsClient) {
        super(defaultSqsClient);
    }

    @Override
    public String getQueueUrl() {
        return this.queueUrl;
    }
}
