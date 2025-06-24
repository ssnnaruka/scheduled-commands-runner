package com.amex.scheduler.factory;

import com.amex.scheduler.model.Command;
import com.amex.scheduler.model.OneTimeCommand;
import com.amex.scheduler.model.RecurringCommand;

public class CommandFactory {
    public static Command getCommand(String line) {
        if (line.startsWith("*/")) {
            return RecurringCommand.parse(line);
        } else {
            return OneTimeCommand.parse(line);
        }
    }
}

