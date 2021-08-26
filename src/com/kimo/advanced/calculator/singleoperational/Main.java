package com.kimo.advanced.calculator.singleoperational;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.PrintUtils;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        PrintUtils.printSeparator();
        System.out.println("Single-operational Calculator - Calculate one operation at time from left to right.");
        mainLoop();
        PrintUtils.printSeparator();
    }

    public static void mainLoop() throws IOException {
        Calculator calculator = new Calculator();

        do {
            int userInput = 0;
            printCommandList();
            System.out.print("-: ");

            userInput = getCaughtInput();

            PrintUtils.printSeparator();
            switch (userInput) {
                case 1:
                    calculator.calculationMode();
                    break;
                case 2:
                    if (!calculator.hasDumped) {
                        calculator.dump();
                    } else {
                        System.out.println("You have already dumped the previous session to the file.");
                    }
                    break;
                case 3:
                    if (calculator.file.exists()) {
                        calculator.file.delete();
                        calculator.hasDumped = false;
                        System.out.println("File has been successfully deleted.");
                    } else if (!calculator.file.exists()) {
                        System.out.println("File does not exist.");
                    }
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
        PrintUtils.printSeparator();
        System.out.println("1. Enter calculation mode.");
        System.out.println("2. Print out calculation results to a dump file.");
        System.out.println("3. Delete the dump file.");
        System.out.println("4. Exit.");
    }

    private static int getCaughtInput() {
        int input = 0;

        try {
            input = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.nextLine();
        }

        return input;
    }
}