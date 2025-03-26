package com.notificationhandler.infrastructure.aws.sqs.pooler;

import com.notificationhandler.infrastructure.aws.sqs.AwsMessagePooler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public abstract class DefaultAwsMessagePooler implements AwsMessagePooler {

    private final SqsClient defaultSqsClient;

    public List<Message> pool() throws Exception {
        try {
            ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                    .queueUrl(getQueueUrl())
                    .maxNumberOfMessages(getMaxNumberOfMessages())
                    .waitTimeSeconds(getWaitTimeSeconds())
                    .build();

            return defaultSqsClient.receiveMessage(request).messages();
        } catch (Exception exception) {
            log.error("Receive sqs message response exception {} ", exception.getMessage());
            throw new Exception("Sqs exception");
        }
    }
}
