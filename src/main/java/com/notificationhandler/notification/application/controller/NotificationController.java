package com.notificationhandler.notification.application.controller;

import com.notificationhandler.notification.application.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> publishNotification(@RequestBody String message) {
        notificationService.publishMessage(message);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<String> getNotification() {
        return ResponseEntity.ok("Sample message");
    }
}
