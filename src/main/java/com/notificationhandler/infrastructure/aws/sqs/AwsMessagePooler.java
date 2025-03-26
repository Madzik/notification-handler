package com.notificationhandler.infrastructure.aws.sqs;

public interface AwsMessagePooler {

    Integer MAX_NUMBER_OF_MESSAGES = 10;
    Integer WAIT_TIME_SECONDS = 10;

    String getQueueUrl();

    default int getMaxNumberOfMessages() {
        return MAX_NUMBER_OF_MESSAGES;
    }

    default int getWaitTimeSeconds() {
        return WAIT_TIME_SECONDS;
    }
}
