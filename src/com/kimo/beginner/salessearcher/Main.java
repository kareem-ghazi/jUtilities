package com.kimo.beginner.salessearcher;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static SalesSearcher csvParser = new SalesSearcher();
    private static File file = new File("src/com/kimo/beginner/salessearcher/SalesRecords.csv");

    public static void main(String[] args) {

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

            csvParser.readFile(file);
            if (!userInput.isBlank()) {
                csvParser.printOrderDetails(userInput);
            } else {
                System.out.println("----------------------------");
                System.out.println("Invalid input.");
            }
        
        } while (true);
    }
}
