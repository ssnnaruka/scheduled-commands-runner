package com.amex.scheduler;

import com.amex.scheduler.service.SchedulerService;

public class Main {
    public static void main(String[] args) {
        SchedulerService scheduler = new SchedulerService();
        scheduler.runScheduler();
    }
}