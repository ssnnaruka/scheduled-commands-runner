package com.amex.scheduler.model;

import java.time.LocalDateTime;

public class OneTimeCommand implements Command {
    private final int minute, hour, day, month, year;
    private final String commandText;

    public OneTimeCommand(int minute, int hour, int day, int month, int year, String commandText) {
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
        this.commandText = commandText;
    }

    public static OneTimeCommand parse(String line) {
        try {
            String[] parts = line.split(" ", 6);
            return new OneTimeCommand(
                    Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]),
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]),
                    parts[5]
            );
        } catch (Exception e) {
            return null;
        }
    }

    public boolean shouldExecute(LocalDateTime now) {
        return now.getMinute() == minute &&
                now.getHour() == hour &&
                now.getDayOfMonth() == day &&
                now.getMonthValue() == month &&
                now.getYear() == year;
    }

    public String getCommandText() {
        return commandText;
    }
}
