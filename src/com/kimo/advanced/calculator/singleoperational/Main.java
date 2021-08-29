package com.kimo.advanced.calculator.singleoperational;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.PrintUtils;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) throws IOException {
        PrintUtils.printSeparator();
        System.out.println("Single-operational Calculator - Calculate one operation at time from left to right.");
        mainLoop();
        PrintUtils.printSeparator();
    }

    public static void mainLoop() throws IOException {
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