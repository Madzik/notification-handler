package com.notificationhandler.configuration.exception.domain.model;

public class BadApiRequestException extends RuntimeException {
    public BadApiRequestException(String message) {
        super(message);
    }
}
