package com.kimo.beginner.agecalculator;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Application application = new Application();
	static User user = new User();

	// Main method to run application.
	public static void main(String[] args) {
		printSeparator();
		System.out.println("Age Calculator - Calculates your current age using your birthday.");
		printCommandList();
		mainLoop();
		printSeparator();

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
		int userInput = 0;

		do {
			System.out.print("-: ");
			try {
				userInput = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
			}

			switch (userInput) {
				case 1:
					printSeparator();
					scan.nextLine();
					System.out.print("Enter your name: ");
					String username = scan.nextLine();

					System.out.print("Enter your nationality: ");
					String nationality = scan.nextLine();

					System.out.print("Enter your birth year: ");
					int birthYear = scan.nextInt();

					System.out.print("Enter your birth month: ");
					int birthMonth = scan.nextInt();

					System.out.print("Enter your birth day: ");
					int birthDay = scan.nextInt();
					scan.nextLine();

					user.setName(username);
					user.setNationality(nationality);
					user.setBirthdate(birthYear, birthMonth, birthDay);

					break;
				case 2:
					printSeparator();
					if (user.getUsername() != null) {
						System.out.println("Name: " + user.getUsername());
						System.out.println("Nationality: " + user.getNationality());
						System.out.println("Birthdate: " + user.getBirthYear() + "/" + user.getBirthMonth() + "/"
								+ user.getBirthDay());
						printSeparator();
						System.out.println(application.calculateAge(user.getBirthdate()));
						System.out.println(application.timeTillNextBirthday(user.getBirthdate()));
					} else {
						System.err.println("You have not set your information yet.");

					}
					break;
				case 3:
					printSeparator();
					if (user.getUsername() != null) {

					} else {
						System.err.println("You have not set your information yet.");
					}
					break;
				case 4:
					printSeparator();
					if (user.getUsername() != null) {
						System.out.println("Your age in seconds is: " + application.calculateAgeInSeconds(user.getBirthdate()));
						System.out.println("Your age in hours is: " + application.calculateAgeInHours(user.getBirthdate()));
						System.out.println("Your age in days is: " + application.calculateAgeInDays(user.getBirthdate()));
					} else {
						System.err.println("You have not set your information yet.");
					}
					break;
				case 5:
					System.out.println("Exited program successfully.");
					return;
				default:
					System.err.println("Invalid input.");
			}

			printSeparator();
			printCommandList();

		} while (true);

	}

}
