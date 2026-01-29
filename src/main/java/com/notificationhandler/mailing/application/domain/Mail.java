package com.notificationhandler.mailing.application.domain;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Mail {
    @Nonnull
    private String sender;
    @Nonnull
    private String subject;
    @Nonnull
    private String content;
    @Nonnull
    private List<String> recipients;
}
