package com.kimo.beginner.agecalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


public class Application {
	Scanner scan = new Scanner(System.in);
	LocalDate today = LocalDate.now(); // Today's date
	LocalDate birthday;
	NumberFormat numberFormat = NumberFormat.getInstance();

	// Calculates the age of a user.
	public String calculateAge(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);

		return "You are " + ageDateDifference.getYears() + " year(s), " + ageDateDifference.getMonths() + " month(s), "
				+ ageDateDifference.getDays() + " day(s) old.";

	}

	// Calculates time till next birthday.
	public String timeTillNextBirthday(LocalDate birthday) {
		LocalDate nextBirthday = birthday.withYear(today.getYear());

		if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
			nextBirthday = nextBirthday.plusYears(1);
		}

		Period nextBirthdate = Period.between(today, nextBirthday);

		if (nextBirthdate.getYears() == 0) {
			return nextBirthdate.getMonths() + " month(s), " + nextBirthdate.getDays()
					+ " day(s) remain until your next birthday.";
		} else {
			return nextBirthdate.getYears() + " year(s), " + nextBirthdate.getMonths() + " month(s), "
					+ nextBirthdate.getDays() + " day(s) remain until your next birthday.";
		}

	}

	public void ageOnDifferentPlanets(int year, int month, int day) {

	}

	public String calculateAgeInSeconds(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);
		int ageInSeconds = ((ageDateDifference.getYears() * 31536000) + (ageDateDifference.getMonths() * 2628002)
				+ (ageDateDifference.getDays() * 86400));

		return numberFormat.format(ageInSeconds);
	}

	public String calculateAgeInHours(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);
		int ageInHours = ((ageDateDifference.getYears() * 31536000) + (ageDateDifference.getMonths() * 2628002)
				+ (ageDateDifference.getDays() * 86400)) / 3600;

		return numberFormat.format(ageInHours);
	}

	public String calculateAgeInDays(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);
		int ageInDays = ((ageDateDifference.getYears() * 31536000) + (ageDateDifference.getMonths() * 2628002)
				+ (ageDateDifference.getDays() * 86400)) / 86400;

		return numberFormat.format(ageInDays);
	}

}
