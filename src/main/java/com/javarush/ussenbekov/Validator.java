package com.javarush.ussenbekov;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public static boolean isValidKey(int key, char[] alphabet) {
        return key > 0 && key < alphabet.length;
    }

    public static boolean isFileExists(String filePath) {
        Path path = Path.of(filePath);
        if (Files.exists(path) && Files.isRegularFile(path)) {
            return true;
        }

        return false;
    }
}
