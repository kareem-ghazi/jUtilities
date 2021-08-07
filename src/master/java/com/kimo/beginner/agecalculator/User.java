package com.kimo.beginner.agecalculator;

import java.time.LocalDate;
import java.util.Scanner;

public class User {
	private String username;
	private String nationality;

	private int birthYear;
	private int birthMonth;
	private int birthDay;

	private LocalDate birthday;
	private Scanner scan = new Scanner(System.in);

	public void createUser() {
		int birthYear = 0;
		int birthMonth = 0;
		int birthDay = 0;

		System.out.print("Enter your name: ");
		String username = scan.nextLine();

		System.out.print("Enter your nationality: ");
		String nationality = scan.nextLine();

		System.out.print("Enter your birth year: ");
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

	public void setName(String username) {
		this.username = username;

	}

	public void setNationality(String nationality) {
		this.nationality = nationality;

	}

	public void setBirthdate(int birthYear, int birthMonth, int birthDay) {
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;

		birthday = LocalDate.of(birthYear, birthMonth, birthDay);
	}

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
		return birthday;

	}

	public int getBirthMonth() {
		return birthMonth;

	}

	public int getBirthYear() {
		return birthYear;

	}

	public int getBirthDay() {
		return birthDay;

	}

}
