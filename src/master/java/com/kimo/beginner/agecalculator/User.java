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
