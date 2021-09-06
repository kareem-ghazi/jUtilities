package com.kimo.advanced.calculator.singleoperational;

import java.io.IOException;

import com.kimo.advanced.calculator.singleoperational.utils.FormatUtil;
import com.kimo.advanced.calculator.singleoperational.utils.InputUtil;

public class Main {
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) throws IOException {
        FormatUtil.printSeparator();
        System.out.println("Single-operational Calculator - Calculate one operation at time from left to right.");
        mainLoop();
        FormatUtil.printSeparator();
    }

    public static void mainLoop() throws IOException {
        do {
            int userInput = 0;
            printCommandList();
            System.out.print("-: ");

            userInput = InputUtil.getCaughtInput();

            FormatUtil.printSeparator();
            switch (userInput) {
                case 1:
                    calculator.calculationMode();
                    break;
                case 2:
                    calculator.dump();
                    break;
                case 3:
                    calculator.deleteDumpFile();
                    break;
                case 4:
                    System.out.println("Exited program successfully.");
                    return;
                default:
                    System.out.println("Invalid input.");
            }

        } while (true);

    }

    private static void printCommandList() {
        FormatUtil.printSeparator();
        System.out.println("1. Enter calculation mode.");
        System.out.println("2. Print out calculation results to a dump file.");
        System.out.println("3. Delete the dump file.");
        System.out.println("4. Exit.");
    }

}