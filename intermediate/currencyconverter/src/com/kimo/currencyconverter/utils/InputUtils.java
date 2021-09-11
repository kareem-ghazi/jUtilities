package com.kimo.currencyconverter.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    public static int getCaughtIntInput(Scanner scan) {
        int input = 0;

        try {
            input = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }

        return input;
    }
    
}
