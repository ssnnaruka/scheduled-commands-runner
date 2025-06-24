package com.amex.scheduler.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandExecutorTest {

    @Test
    public void testExecute_ValidCommand() {
        String output = CommandExecutor.execute("echo 'Hello'");
        assertEquals("Hello", output.trim());
    }

    @Test
    public void testExecute_InvalidCommand() {
        String output = CommandExecutor.execute("non_existent_command_123");
        assertTrue(output.contains("Error executing command"));
    }
}
