package com.amex.scheduler.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OneTimeCommandTest {

    @Test
    public void testShouldExecute_WhenDateMatches() {
        LocalDateTime dt = LocalDateTime.of(2025, 6, 30, 10, 45);
        OneTimeCommand cmd = new OneTimeCommand(45, 10, 30, 6, 2025, "echo 'hello'");
        assertTrue(cmd.shouldExecute(dt));
    }

    @Test
    public void testShouldExecute_WhenDateDoesNotMatch() {
        LocalDateTime dt = LocalDateTime.of(2025, 6, 30, 10, 44);
        OneTimeCommand cmd = new OneTimeCommand(45, 10, 30, 6, 2025, "echo 'hello'");
        assertFalse(cmd.shouldExecute(dt));
    }

    @Test
    public void testParse_ValidOneTime() {
        OneTimeCommand cmd = OneTimeCommand.parse("30 10 15 7 2025 echo 'once'");
        assertNotNull(cmd);
        assertEquals("echo 'once'", cmd.getCommandText());
    }

    @Test
    public void testParse_InvalidOneTime() {
        OneTimeCommand cmd = OneTimeCommand.parse("30 10 15 7 echo 'fail'");
        assertNull(cmd);
    }
}

