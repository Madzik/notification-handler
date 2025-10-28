package com.notificationhandler.infrastructure.scheduler;

public interface ScheduledJob {

    void process() throws Exception;
}
