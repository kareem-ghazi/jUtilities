package com.kimo.beginner.agecalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


public class Application {
	Scanner scan = new Scanner(System.in);
	LocalDate today = LocalDate.now(); // Today's date
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

	public String calculateAgeInSeconds(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);
		long ageInSeconds = ((ageDateDifference.getYears() * 31536000L) + (ageDateDifference.getMonths() * 2628002)
				+ (ageDateDifference.getDays() * 86400));

		return numberFormat.format(ageInSeconds);
	}

	public String calculateAgeInHours(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);
		long ageInHours = ((ageDateDifference.getYears() * 31536000L) + (ageDateDifference.getMonths() * 2628002)
				+ (ageDateDifference.getDays() * 86400)) / 3600;

		return numberFormat.format(ageInHours);
	}

	public String calculateAgeInDays(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);
		long ageInDays = (((ageDateDifference.getYears() * 31536000L) + (ageDateDifference.getMonths() * 2628002)
				+ (ageDateDifference.getDays() * 86400)) / 86400);

		return numberFormat.format(ageInDays);
	}

	public void calculateAgeOnPlanets(LocalDate birthday) {
		Period ageDateDifference = Period.between(birthday, today);

		double earthAge = ageDateDifference.getYears();
		double mercuryAge = (earthAge * 365) / 88;
		double venusAge = (earthAge * 365) / 225;
		double marsAge = (earthAge * 365) / 687;

		double jupiterAge = earthAge / 12;
		double saturnAge = earthAge / 29.5;
		double uranusAge = earthAge / 84;
		double neptuneAge = earthAge / 165;
		double plutoAge = earthAge / 248;

		System.out.println("Your age in years on different planets:");
		System.out.println();
		System.out.println("Mercury - " + Math.round(mercuryAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Earth - " + Math.round(earthAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Venus - " + Math.round(venusAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Mars - " + Math.round(marsAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Jupiter - " + Math.round(jupiterAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Saturn - " + Math.round(saturnAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Uranus - " + Math.round(uranusAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Neptune - " + Math.round(neptuneAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Pluto - " + Math.round(plutoAge * 100.0) / 100.0 + " year(s)");
	}

}
