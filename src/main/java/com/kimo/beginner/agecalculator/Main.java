package com.kimo.beginner.agecalculator;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Application application = new Application();
	static User user = new User();

	// Main method to run application.
	public static void main(String[] args) {
		printSeparator();
		System.out.println("AgeCalculator - Calculates your current age using your birthday.");
		printCommandList();
		mainLoop();

	}

	// Prints a brief description about the program.
	public static void printCommandList() {
		System.out.println("1. Setup your birthdate.");
		System.out.println("2. Print out a summary about your birthdate.");
		System.out.println("3. Print out your age on different planets.");
		System.out.println("4. Print out your age in different times.");
		System.out.println("5. Exit.");

	}

	// Prints a separator between program sessions.
	private static void printSeparator() {
		System.out.println("-------------------------------------");

	}

	// Prints out the calculated age using the specified input values.
	public static void mainLoop() {
		int userInput;

		do {
			userInput = 0;

			System.out.print("-: ");
			try {
				userInput = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
			}

			printSeparator();
			switch (userInput) {
				case 1:
					scan.nextLine(); // Discard previous scanner.
					user.createUser();
					break;
				case 2:
					if (!user.isNull()) {
						System.out.println("Name: " + user.getUsername());
						System.out.println("Nationality: " + user.getNationality());
						System.out.println("Birthdate: " + user.getBirthDay() + "/" + user.getBirthMonth() + "/"
								+ user.getBirthYear());
						printSeparator();
						System.out.println(application.calculateAge(user.getBirthdate()));
						System.out.println(application.timeTillNextBirthday(user.getBirthdate()));
					} else {
						System.err.println("You have not set your information yet.");
					}
					break;
				case 3:
					if (!user.isNull()) {
						application.calculateAgeOnPlanets(user.getBirthdate());
					} else {
						System.err.println("You have not set your information yet.");
					}
					break;
				case 4:
					if (!user.isNull()) {
						System.out.println(
								"Your age in seconds is: " + application.calculateAgeInSeconds(user.getBirthdate()));
						System.out.println(
								"Your age in hours is: " + application.calculateAgeInHours(user.getBirthdate()));
						System.out
								.println("Your age in days is: " + application.calculateAgeInDays(user.getBirthdate()));
					} else {
						System.err.println("You have not set your information yet.");
					}
					break;
				case 5:
					System.out.println("Exited program successfully.");
					printSeparator();
					return;
				default:
					System.err.println("Invalid input.");
			}

			printSeparator();
			printCommandList();

		} while (true);

	}

}
