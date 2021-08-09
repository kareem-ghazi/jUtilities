package com.kimo.beginner.agecalculator;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static Application application = new Application();
	private static User user;

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
				scan.nextLine();
			}

			printSeparator();
			switch (userInput) {
				case 1:
					int birthYear;
					int birthMonth;
					int birthDay;

					String username;
					String nationality;

					scan.nextLine(); // Discard previous scanner.
					System.out.print("Enter your name: ");
					username = scan.nextLine();

					System.out.print("Enter your nationality: ");
					nationality = scan.nextLine();

					System.out.print("Enter your birth year: ");
					// Try-catch statements for invalid input.
					do {
						try {
							birthYear = scan.nextInt();
							break;
						} catch (Exception e) {
							scan.nextLine();
							System.out.println("Invalid input.");
							System.out.print("-: ");
						}
					} while (true);
					scan.nextLine();

					System.out.print("Enter your birth month: ");
					do {
						try {
							birthMonth = scan.nextInt();
							break;
						} catch (Exception e) {
							scan.nextLine();
							System.out.println("Invalid input.");
							System.out.print("-: ");
						}
					} while (true);
					scan.nextLine();

					System.out.print("Enter your birth day: ");
					do {
						try {
							birthDay = scan.nextInt();
							break;
						} catch (Exception e) {
							scan.nextLine();
							System.out.println("Invalid input.");
							System.out.print("-: ");
						}
					} while (true);
					scan.nextLine();

					user = new User(username, nationality, birthYear, birthMonth, birthDay);
					break;
				case 2:
					if (!user.isNull()) {
						System.out.println("Name: " + user.getUsername());
						System.out.println("Nationality: " + user.getNationality());
						System.out.println("Birthdate: " + user.getBirthdate().getDayOfMonth() + "/"
								+ user.getBirthdate().getMonthValue() + "/" + user.getBirthdate().getYear());
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
					return; // Exits out of the method and the program technically.
				default:
					System.err.println("Invalid input.");
			}

			printSeparator();
			printCommandList();

		} while (true);

	}

}
