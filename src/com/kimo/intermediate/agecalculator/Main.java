package com.kimo.intermediate.agecalculator;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static OptionMenu option = new OptionMenu();

	// Main method to run application.
	public static void main(String[] args) {
		printSeparator();
		System.out.println("AgeCalculator - Calculates your current age using your birthday.");
		printCommandList();
		mainLoop();

	}

	// Prints the command list for the application.
	public static void printCommandList() {
		System.out.println("1. Setup your birthdate.");
		System.out.println("2. Print out a summary about your birthdate.");
		System.out.println("3. Print out your age on different planets.");
		System.out.println("4. Print out your age in different times.");
		System.out.println("5. Exit.");

	}

	// Prints a separator.
	private static void printSeparator() {
		System.out.println("-------------------------------------");

	}

	// Main loop where menu options are processed.
	public static void mainLoop() {
		int userInput;

		do {
			userInput = 0;

			System.out.print("-: ");
			try {
				userInput = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine(); // Discard scanner
			}

			printSeparator();
			switch (userInput) {
				case 1:
					option.createUser();
					break;
				case 2:
					option.printUserInformation();
					break;
				case 3:
					option.printAgeOnPlanets();
					break;
				case 4:
					option.printAgeInIntervals();
					break;
				case 5:
					option.printExitMessage();
					return; // Exits out of the method and the program technically.
				default:
					System.err.println("Invalid input.");
			}

			printSeparator();
			printCommandList();

		} while (true);

	}

}
