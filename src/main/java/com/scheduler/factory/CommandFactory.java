package com.scheduler.factory;

import com.scheduler.model.Command;
import com.scheduler.model.OneTimeCommand;
import com.scheduler.model.RecurringCommand;

public class CommandFactory {
    public static Command getCommand(String line) {
        if (line.startsWith("*/")) {
            return RecurringCommand.parse(line);
        } else {
            return OneTimeCommand.parse(line);
        }
    }
}

