package com.amex.scheduler.factory;

import com.amex.scheduler.model.Command;
import com.amex.scheduler.model.OneTimeCommand;
import com.amex.scheduler.model.RecurringCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandFactoryTest {

    @Test
    public void testGetCommand_RecurringCommand() {
        String line = "*/5 echo 'recurring'";
        Command cmd = CommandFactory.getCommand(line);
        assertTrue(cmd instanceof RecurringCommand);
        assertEquals("echo 'recurring'", cmd.getCommandText());
    }

    @Test
    public void testGetCommand_OneTimeCommand() {
        String line = "15 10 30 6 2025 echo 'once'";
        Command cmd = CommandFactory.getCommand(line);
        assertTrue(cmd instanceof OneTimeCommand);
        assertEquals("echo 'once'", cmd.getCommandText());
    }

    @Test
    public void testGetCommand_InvalidOneTime() {
        String line = "15 10 30 6 echo";  // Missing year
        Command cmd = CommandFactory.getCommand(line);
        assertNull(cmd);
    }

    @Test
    public void testGetCommand_InvalidRecurring() {
        String line = "**/5 echo 'bad format'";
        Command cmd = CommandFactory.getCommand(line);
        assertNull(cmd);
    }
}
