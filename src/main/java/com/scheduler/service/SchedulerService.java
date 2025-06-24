package com.scheduler.service;

import com.scheduler.model.Command;
import com.scheduler.factory.CommandFactory;
import com.scheduler.util.FileUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class SchedulerService {
    private static final String COMMAND_FILE = "/tmp/commands.txt";

    public void runScheduler() {
        while (true) {
            try {
                List<String> lines = loadCommands();
                processOnce(lines, LocalDateTime.now());
                sleepOneMinute();
            } catch (Exception e) {
                System.err.println("Scheduler error: " + e.getMessage());
            }
        }
    }

    public List<String> loadCommands() throws IOException {
        return FileUtil.readFile(COMMAND_FILE);
    }

    public void processOnce(List<String> lines, LocalDateTime now) {
        for (String line : lines) {
            Command command = CommandFactory.getCommand(line);
            if (command != null && command.shouldExecute(now)) {
                String output = CommandExecutor.execute(command.getCommandText());
                FileUtil.writeToOutput(now, output);
            }
        }
    }

    private void sleepOneMinute() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
