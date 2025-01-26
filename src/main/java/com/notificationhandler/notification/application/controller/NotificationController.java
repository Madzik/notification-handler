package com.notificationhandler.notification.application.controller;

import com.notificationhandler.notification.application.service.NotificationPublisher;
import com.notificationhandler.notification.application.service.NotificationSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationPublisher notificationPublisher;
    private final NotificationSubscriber notificationSubscriber;

    @PostMapping
    public ResponseEntity<Void> publishNotification(@RequestBody String message) {
        notificationPublisher.publishMessage(message);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<String> getNotification() {
        return ResponseEntity.ok(notificationSubscriber.consumeMessage());
    }
}
