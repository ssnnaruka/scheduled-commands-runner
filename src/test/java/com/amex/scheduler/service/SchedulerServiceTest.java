package com.amex.scheduler.service;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SchedulerServiceTest {

    @Test
    public void testProcessOnce_OneTimeMatch() {
        List<String> commands = Arrays.asList("30 10 30 6 2025 echo 'once match'");
        LocalDateTime now = LocalDateTime.of(2025, 6, 30, 10, 30);
        SchedulerService scheduler = new SchedulerService();
        scheduler.processOnce(commands, now);
        // Check if sample-output.txt has the expected content (optional)
    }

    @Test
    public void testProcessOnce_RecurringMatch() {
        List<String> commands = Arrays.asList("*/15 echo 'recurring match'");
        LocalDateTime now = LocalDateTime.of(2025, 6, 30, 12, 45);
        SchedulerService scheduler = new SchedulerService();
        scheduler.processOnce(commands, now);
    }

    @Test
    public void testProcessOnce_InvalidCommand() {
        List<String> commands = Arrays.asList("bad input line");
        SchedulerService scheduler = new SchedulerService();
        scheduler.processOnce(commands, LocalDateTime.now());
        // No exception = success
    }
}
