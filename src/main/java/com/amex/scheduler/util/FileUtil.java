package com.amex.scheduler.util;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileUtil {
    private static final String OUTPUT_FILE = "sample-output.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    public static void writeToOutput(LocalDateTime timestamp, String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
            writer.write("[" + formatter.format(timestamp) + "] Output:\n");
            writer.write(output + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

