package com.scheduler.model;

import java.time.LocalDateTime;

public class RecurringCommand implements Command {
    private final int interval;
    private final String commandText;

    public RecurringCommand(int interval, String commandText) {
        this.interval = interval;
        this.commandText = commandText;
    }

    public static RecurringCommand parse(String line) {
        try {
            String[] parts = line.split(" ", 2);
            int interval = Integer.parseInt(parts[0].substring(2));
            return new RecurringCommand(interval, parts[1]);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean shouldExecute(LocalDateTime now) {
        return now.getMinute() % interval == 0;
    }

    public String getCommandText() {
        return commandText;
    }
}
