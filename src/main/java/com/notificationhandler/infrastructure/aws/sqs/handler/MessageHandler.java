package com.notificationhandler.infrastructure.aws.sqs.handler;

public interface MessageHandler {

    String getType();

    void handle(String messageType, String message);
}