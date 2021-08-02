package com.kimo.agecalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Application {
	Scanner scan = new Scanner(System.in);
	Period dateDifference;
	LocalDate today;
	LocalDate birthday;

	// Calculates the age of a user.
	public String calculateAge(int year, int month, int day) {
		LocalDate today = LocalDate.now(); // Today's date
		LocalDate birthday = LocalDate.of(year, month, day); // Birth date
		Period dateDifference = Period.between(birthday, today);

		return "You are " + dateDifference.getYears() + " year(s), " + dateDifference.getMonths() + " month(s), "
				+ dateDifference.getDays() + " day(s) old.";

	}

	// Prints out the calculated age using the specified input values.
	public void printCalculatedAge() {
		System.out.print("Enter your birth year: ");
		int birthYear = scan.nextInt();
		System.out.print("Enter your birth month: ");
		int birthMonth = scan.nextInt();
		System.out.print("Enter your birth day: ");
		int birthDay = scan.nextInt();
		scan.nextLine();

		System.out.println(calculateAge(birthYear, birthMonth, birthDay));
		System.out.println(timeTillNextBirthday(birthYear, birthMonth, birthDay));
	}
	
	// Calculates time till next birthday.
	public String timeTillNextBirthday(int year, int month, int day) {
		today = LocalDate.now(); // Today's date
		birthday = LocalDate.of(year, month, day); // Birth date
		
		LocalDate nextBirthday = birthday.withYear(today.getYear());
		
		if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
		
		dateDifference = Period.between(today, nextBirthday);
		
		return dateDifference.getYears()+ " year(s), " + dateDifference.getMonths() + " month(s), "
				+ dateDifference.getDays() + " day(s) remain until your next birthday.";

	}
	
}
