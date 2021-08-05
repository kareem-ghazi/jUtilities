package com.kimo.beginner.agecalculator;

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
		dateDifference = Period.between(birthday, today);

		return "You are " + dateDifference.getYears() + " year(s), " + dateDifference.getMonths() + " month(s), "
				+ dateDifference.getDays() + " day(s) old.";

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

		if (dateDifference.getYears() == 0) {
			return dateDifference.getMonths() + " month(s), "
					+ dateDifference.getDays() + " day(s) remain until your next birthday.";
		} else {
			return dateDifference.getYears() + " year(s), " + dateDifference.getMonths() + " month(s), "
					+ dateDifference.getDays() + " day(s) remain until your next birthday.";
		}
		
	}

}
