package com.notificationhandler.notification.application.controller;

import com.notificationhandler.notification.application.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> publishNotification(String message) {
        notificationService.publishMessage(message);
        return ResponseEntity.ok().build();
    }
}
