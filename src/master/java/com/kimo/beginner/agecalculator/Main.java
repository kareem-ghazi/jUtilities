package com.kimo.beginner.agecalculator;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Application application = new Application();

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
		System.out.println("2. Print out a summary about you using your birthdate.");
		System.out.println("3. Print out your age on different planets.");
		System.out.println("4. Exit.");
		
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
				System.err.println("Invalid input");
				
			}
			
			switch (userInput) {
			case 1:
				User user1 = new User();
				
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
				
				user1.setName(username);
				user1.setNationality(nationality);
				user1.setBirthdate(birthYear, birthMonth, birthDay);
				
				System.out.println(user1.getUsername());
				System.out.println(user1.getNationality());
				break;
				
			case 4:
				return;
				
			}
			
			printSeparator();
			printCommandList();
			
		} while (true);

	}

}
