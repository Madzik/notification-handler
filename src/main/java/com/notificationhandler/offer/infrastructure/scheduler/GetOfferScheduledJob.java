package com.notificationhandler.offer.infrastructure.scheduler;

import com.notificationhandler.infrastructure.scheduler.ScheduledJob;
import com.notificationhandler.notification.infrastructure.OfferSubmittedAbstractNotificationSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetOfferScheduledJob implements ScheduledJob {

    private final OfferSubmittedAbstractNotificationSubscriber subscriber;

    @Scheduled(fixedRate = 30000)
    public void process() {
        this.subscriber.consumeMessage();
    }
}
