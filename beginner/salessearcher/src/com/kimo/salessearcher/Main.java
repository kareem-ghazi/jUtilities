package com.kimo.salessearcher;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static SalesSearcher salesSearcher = new SalesSearcher();
    private static File file = new File("src/com/kimo/beginner/salessearcher/SalesRecords.csv");

    public static void main(String[] args) {
        System.out.println("SalesSearcher - Searches through sales data and prints out the order details.");
        
        do {
            System.out.println("----------------------------");
            System.out.println("Enter order ID: ");
            System.out.print("-: ");
            String userInput = scan.nextLine();

            if (userInput.equals("!q")) {
                System.out.println("Exited program successfully.");
                System.out.println("----------------------------");
                System.exit(0);
            }

            salesSearcher.readFile(file);
            if (isNumeric(userInput)) {
                salesSearcher.printOrderDetails(userInput);
            } else {
                System.out.println("----------------------------");
                System.out.println("Invalid input.");
            }
        
        } while (true);
    }

    // Checks if the string is a number.
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
