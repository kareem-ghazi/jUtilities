package com.kimo.beginner.agecalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;


public class Application {
	private LocalDate today = LocalDate.now(); // Today's date
	private NumberFormat numberFormat = NumberFormat.getInstance();
	private Period dateDifference;

	// Calculates the age of a user.
	public String calculateAge(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);

		return "You are " + dateDifference.getYears() + " year(s), " + dateDifference.getMonths() + " month(s), "
				+ dateDifference.getDays() + " day(s) old.";

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
	
	// Calculates age in seconds.
	public String calculateAgeInSeconds(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);
		long ageInSeconds = ((dateDifference.getYears() * 31536000L) + (dateDifference.getMonths() * 2628002)
				+ (dateDifference.getDays() * 86400));

		return numberFormat.format(ageInSeconds);
	}

	// Calculates age in hours.
	public String calculateAgeInHours(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);
		long ageInHours = ((dateDifference.getYears() * 31536000L) + (dateDifference.getMonths() * 2628002)
				+ (dateDifference.getDays() * 86400)) / 3600;

		return numberFormat.format(ageInHours);
	}

	// Calculates age in days.
	public String calculateAgeInDays(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);
		long ageInDays = (((dateDifference.getYears() * 31536000L) + (dateDifference.getMonths() * 2628002)
				+ (dateDifference.getDays() * 86400)) / 86400);

		return numberFormat.format(ageInDays);
	}

	// Calculates age on different solar planets and prints out the results.
	public void calculateAgeOnPlanets(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);

		double earthAge = dateDifference.getYears();
		double mercuryAge = (earthAge * 365) / 88; // 88 days = 1 year on Mercury.
		double venusAge = (earthAge * 365) / 225; // 225 days = 1 year on Venus.
		double marsAge = (earthAge * 365) / 687; // 687 days = 1 year on Mars.

		double jupiterAge = earthAge / 12; // 12 years = 1 year on Jupiter.
		double saturnAge = earthAge / 29.5; // 29.5 years = 1 year on Saturn.
		double uranusAge = earthAge / 84; // 84 years = 1 year on Uranus.
		double neptuneAge = earthAge / 165; // 165 years = 1 year on Neptune.
		double plutoAge = earthAge / 248; // 248 years = 1 year on Pluto.

		System.out.println("Your age in years on different planets:");
		System.out.println();
		System.out.println("Mercury - " + Math.round(mercuryAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Venus - " + Math.round(venusAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Earth - " + Math.round(earthAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Mars - " + Math.round(marsAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Jupiter - " + Math.round(jupiterAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Saturn - " + Math.round(saturnAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Uranus - " + Math.round(uranusAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Neptune - " + Math.round(neptuneAge * 100.0) / 100.0 + " year(s)");
		System.out.println("Pluto - " + Math.round(plutoAge * 100.0) / 100.0 + " year(s)");
	}

}
