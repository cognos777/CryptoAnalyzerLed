package com.javarush.ussenbekov;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Cipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '1', '2',
            '3', '4', '5', '6', '7', '8', '9', '0'};

    private static final String INPUT_FILE_TXT = "Please enter input file path";
    private static final String OUTPUT_FILE_TXT = "Please enter output file path";
    private static final String KEY_TXT = "Please enter key";
    private static final String INCORRECT_FILE = "Your file is incorrect";
    private static final String INCORRECT_KEY = "Your key is incorrect";

    public static void encrypt() throws IOException {
        String inputFile, outputFile;
        int key;
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_FILE_TXT);
        inputFile = scanner.nextLine();
        if (Validator.isFileExists(inputFile) == false) {
            System.out.println(INCORRECT_FILE);
            return;
        }

        System.out.println(OUTPUT_FILE_TXT);
        outputFile = scanner.nextLine();
        if (Validator.isFileExists(outputFile) == false) {
            System.out.println(INCORRECT_FILE);
            return;
        }

        System.out.println(KEY_TXT);
        key = scanner.nextInt();
        if (Validator.isValidKey(key, ALPHABET) == false) {
            System.out.println(INCORRECT_KEY);
            return;
        }

        String inputTxt = FileManager.readFile(inputFile);
        char[] symbols = inputTxt.toCharArray();
        char[] newSymbols = new char[symbols.length];

        for (int i = 0; i < symbols.length; i++) {
            char currentChar = symbols[i];

            int index = -1;
            for (int j = 0; j < ALPHABET.length; j++) {
                if(ALPHABET[j]==currentChar) {
                    index = j;
                    break;
                }
            }

            if (index != -1) {
                int newIndex = (index + key) % ALPHABET.length;
                if (newIndex < 0) {
                    newIndex += ALPHABET.length;
                }
                newSymbols[i] = ALPHABET[newIndex];
            } else {
                newSymbols[i] = currentChar;
            }
        }

        String encryptedText = new String(newSymbols);
        System.out.println("Encrypted: "+encryptedText);
        FileManager.writeFile(encryptedText, outputFile);

    }

    public static void decrypt() throws IOException {
        String inputFile, outputFile;
        int key;
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_FILE_TXT);
        inputFile = scanner.nextLine();
        if (Validator.isFileExists(inputFile) == false) {
            System.out.println(INCORRECT_FILE);
            return;
        }

        System.out.println(OUTPUT_FILE_TXT);
        outputFile = scanner.nextLine();
        if (Validator.isFileExists(outputFile) == false) {
            System.out.println(INCORRECT_FILE);
            return;
        }

        System.out.println(KEY_TXT);
        key = scanner.nextInt();
        if (Validator.isValidKey(key, ALPHABET) == false) {
            System.out.println(INCORRECT_KEY);
            return;
        }

        String inputTxt = FileManager.readFile(inputFile);
        char[] symbols = inputTxt.toCharArray();
        char[] newSymbols = new char[symbols.length];

        for (int i = 0; i < symbols.length; i++) {
            char currentChar = symbols[i];

            int index = -1;
            for (int j = 0; j < ALPHABET.length; j++) {
                if(ALPHABET[j]==currentChar) {
                    index = j;
                    break;
                }
            }

            if (index != -1) {
                int newIndex = (index - key) % ALPHABET.length;
                if (newIndex < 0) {
                    newIndex += ALPHABET.length;
                }
                newSymbols[i] = ALPHABET[newIndex];
            } else {
                newSymbols[i] = currentChar;
            }
        }

        String encryptedText = new String(newSymbols);
        System.out.println("Decrypted: "+encryptedText);
        FileManager.writeFile(encryptedText, outputFile);
    }
}
