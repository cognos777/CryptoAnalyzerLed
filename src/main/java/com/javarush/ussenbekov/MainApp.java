package com.javarush.ussenbekov;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String mainMenuTxt = """
                ------------------------------
                Please select operation:
                1. Encrypt
                2. Decrypt
                3. Exit
                ------------------------------
                """;

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println(mainMenuTxt);
            System.out.print("You selected: ");

            if (scanner.hasNextInt()) {
                int mode = scanner.nextInt();
                scanner.nextLine();
                running = false;
                switch (mode) {
                    case 1:
                        System.out.println("Encrypt...");
                        try {
                            Cipher.encrypt();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        System.out.println("Decrypt...");
                        try {
                            Cipher.decrypt();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        System.out.println("Exit...");
                        break;
                    default:
                        System.out.println("Incorrect operation. Repeat please.");
                        running = true;
                        break;
                }
            } else {
                System.out.println("Error: please input number between 1-3.");
                scanner.nextLine();
            }
        }


    }
}
