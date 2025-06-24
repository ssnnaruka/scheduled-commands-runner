package com.scheduler;

import com.scheduler.service.SchedulerService;

public class Main {
    public static void main(String[] args) {
        SchedulerService scheduler = new SchedulerService();
        scheduler.runScheduler();
    }
}