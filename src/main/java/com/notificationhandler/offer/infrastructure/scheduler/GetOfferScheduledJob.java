package com.notificationhandler.offer.infrastructure.scheduler;

import com.notificationhandler.infrastructure.scheduler.ScheduledJob;
import com.notificationhandler.notification.application.service.NotificationSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetOfferScheduledJob implements ScheduledJob {

    private final NotificationSubscriber notificationSubscriber;

    @Scheduled(fixedRate = 30000)
    public void process() throws Exception {
        this.notificationSubscriber.consumeMessage();
    }
}
