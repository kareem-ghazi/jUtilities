package com.kimo.beginner.guessthenumber.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    private static Scanner scan = new Scanner(System.in);

    public static int getCaughtInput() {
        int input = 0;

        try {
            input = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }

        return input;
    }
}
