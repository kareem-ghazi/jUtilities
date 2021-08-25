package com.kimo.advanced.calculator.singleoperational;

import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.PrintUtils;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        PrintUtils.printSeparator();
        System.out.println("Single-operational Calculator - Calculate one operation at time from left to right.");
        mainLoop();
        PrintUtils.printSeparator();
    }

    public static void mainLoop() {
        Calculator calculator = new Calculator();

        do {
            int userInput = 0;
            printCommandList();
            System.out.print("-: ");

            userInput = getCaughtInput();

            switch (userInput) {
                case 1:
                    calculator.calculationMode();
                    break;
                case 3:
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
        System.out.println("2. Print out calculation results into a text file.");
        System.out.println("3. Exit.");
    }

    private static int getCaughtInput() {
        int input = 0;

        try {
            input = scan.nextInt();
        } catch (Exception e) {
            scan.nextLine();
        }

        return input;
    }
}