package com.notificationhandler.notification.application.controller;

import com.notificationhandler.infrastructure.aws.sns.NotificationPublisher;
import com.notificationhandler.notification.infrastructure.NotificationSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

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
    public ResponseEntity<Void> getNotification() {
        try {
            notificationSubscriber.consumeMessage();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/encode")
    public ResponseEntity<String> encode() {

        // Your username and password
        String username = "user";
        String password = "password123";

        // Concatenate username and password with a colon
        String auth = username + ":" + password;

        // Encode to Base64
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());

        // Output the Base64 encoded string
        System.out.println("Encoded Authorization: " + encodedAuth);
        return ResponseEntity.ok(encodedAuth);

    }
}
