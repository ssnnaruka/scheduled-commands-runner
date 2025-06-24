package com.scheduler.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandExecutor {
    public static String execute(String commandText) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = runCommand(commandText);
            appendStream(process.getInputStream(), output);
            appendStream(process.getErrorStream(), output, "Error executing command: ");
        } catch (Exception e) {
            output.append("Error executing command: ").append(e.getMessage());
        }
        return output.toString().trim();
    }

    private static Process runCommand(String command) throws IOException {
        return new ProcessBuilder("bash", "-c", command).start();
    }

    private static void appendStream(InputStream inputStream, StringBuilder output) throws IOException {
        appendStream(inputStream, output, "");
    }

    private static void appendStream(InputStream inputStream, StringBuilder output, String prefix) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(prefix).append(line).append("\n");
            }
        }
    }
}
