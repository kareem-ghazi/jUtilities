package com.kimo.alarmclock.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    public static int getValidInput(Scanner scanner, String type) {
        switch (type.toUpperCase()) {
            case "INT":
                int input = 0;

                try {
                    input = scanner.nextInt();
                    return input;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                }

                break;
            default:
                System.out.println("An error occured, type '" + type + "' is invalid.");
                break;
        }

        return 0;
    }
}
