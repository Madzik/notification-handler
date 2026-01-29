package com.notificationhandler.notification.application.domain.model;

import software.amazon.awssdk.services.sqs.model.Message;

public interface NotificationSubscriber {

    String getQueueUrl();

    void processMessage(Message message);

    void consumeMessage();
}
