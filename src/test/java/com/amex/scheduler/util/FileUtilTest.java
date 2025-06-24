package com.amex.scheduler.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilTest {

    @Test
    public void testReadFile_FileExists() throws IOException {
        Files.write(Paths.get("testfile.txt"), "Hello\nWorld".getBytes());
        List<String> lines = FileUtil.readFile("testfile.txt");
        assertEquals(2, lines.size());
    }

    @Test
    public void testWriteToOutput_CreatesOutput() {
        FileUtil.writeToOutput(LocalDateTime.now(), "Sample output");
        assertTrue(Files.exists(Paths.get("sample-output.txt")));
    }
}
