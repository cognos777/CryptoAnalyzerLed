package com.javarush.ussenbekov;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }


    public static void writeFile(String content, String filePath) throws IOException {
        Files.write(Path.of(filePath), content.getBytes(StandardCharsets.UTF_8));
    }
}
