package com.text_from_page.logging;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logger {
    private static final String FILE_PATH = "log.txt";

    public void log(String errorMessage) {

        File file = new File(FILE_PATH);
        if (file.exists()) {
            try {
                Files.write(Paths.get(FILE_PATH), errorMessage.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            try {
                file.createNewFile();
                Files.write(Paths.get(FILE_PATH), errorMessage.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
