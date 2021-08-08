package com.kimo.beginner.agecalculator;

import java.time.LocalDate;
import java.util.Scanner;

public class User {
	private String username;
	private String nationality;

	private LocalDate birthdate;
	private Scanner scan = new Scanner(System.in);

	// Interface for creating a user.
	public void createUser() {
		int birthYear = 0;
		int birthMonth = 0;
		int birthDay = 0;

		System.out.print("Enter your name: ");
		String username = scan.nextLine();

		System.out.print("Enter your nationality: ");
		String nationality = scan.nextLine();

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

		setName(username);
		setNationality(nationality);
		setBirthdate(birthYear, birthMonth, birthDay);
	}

	// Sets user's name.
	public void setName(String username) {
		this.username = username;

	}

	// Sets user's nationality.
	public void setNationality(String nationality) {
		this.nationality = nationality;

	}

	// Set user's birthdate.
	public void setBirthdate(int birthYear, int birthMonth, int birthDay) {
		birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
	}

	// Checks if the username for the user is null.
	public boolean isNull() {
		return getUsername() == null;
		
	}

	public String getUsername() {
		return username;

	}

	public String getNationality() {
		return nationality;

	}

	public LocalDate getBirthdate() {
		return birthdate;

	}

}
