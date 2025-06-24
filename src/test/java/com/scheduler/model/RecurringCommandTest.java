package com.scheduler.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class RecurringCommandTest {

    @Test
    public void testShouldExecute_WhenMinuteMatches() {
        RecurringCommand cmd = new RecurringCommand(5, "echo 'Hi'");
        LocalDateTime dt = LocalDateTime.of(2025, 6, 30, 12, 10);
        assertTrue(cmd.shouldExecute(dt));
    }

    @Test
    public void testShouldExecute_WhenMinuteDoesNotMatch() {
        RecurringCommand cmd = new RecurringCommand(5, "echo 'Hi'");
        LocalDateTime dt = LocalDateTime.of(2025, 6, 30, 12, 7);
        assertFalse(cmd.shouldExecute(dt));
    }

    @Test
    public void testParse_ValidRecurring() {
        RecurringCommand cmd = RecurringCommand.parse("*/15 echo 'test'");
        assertNotNull(cmd);
        assertEquals("echo 'test'", cmd.getCommandText());
    }

    @Test
    public void testParse_InvalidRecurring() {
        RecurringCommand cmd = RecurringCommand.parse("**/15 echo 'bad'");
        assertNull(cmd);
    }
}
