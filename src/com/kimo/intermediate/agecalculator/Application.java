package com.kimo.intermediate.agecalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;

public class Application {
	private LocalDate today = LocalDate.now(); // Today's date
	private NumberFormat numberFormat = NumberFormat.getInstance();
	private Period dateDifference;

	// Calculates the age of a user.
	public String getAge(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);

		return "You are " + dateDifference.getYears() + " year(s), " + dateDifference.getMonths() + " month(s), "
				+ dateDifference.getDays() + " day(s) old.";

	}

	// Calculates time till next birthday.
	public String getNextBirthday(LocalDate birthday) {
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
	public String getAgeInSeconds(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);
		long ageInSeconds = ((dateDifference.getYears() * 31536000L) + (dateDifference.getMonths() * 2628002)
				+ (dateDifference.getDays() * 86400));

		return numberFormat.format(ageInSeconds);
	}

	// Calculates age in hours.
	public String getAgeInHours(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);
		long ageInHours = ((dateDifference.getYears() * 31536000L) + (dateDifference.getMonths() * 2628002)
				+ (dateDifference.getDays() * 86400)) / 3600;

		return numberFormat.format(ageInHours);
	}

	// Calculates age in days.
	public String getAgeInDays(LocalDate birthday) {
		dateDifference = Period.between(birthday, today);
		long ageInDays = (((dateDifference.getYears() * 31536000L) + (dateDifference.getMonths() * 2628002)
				+ (dateDifference.getDays() * 86400)) / 86400);

		return numberFormat.format(ageInDays);
	}

	// Calculates age on different solar planets and prints out the result.
	public double getAgeOnPlanet(LocalDate birthday, String planet) {
		dateDifference = Period.between(birthday, today);

		double earthAge = dateDifference.getYears();

		switch (planet) {
			case "mercury":
				double mercuryAge = (earthAge * 365) / 88; // 88 days = 1 year on Mercury.
				return Math.round(mercuryAge * 100.0) / 100.0;
			case "venus":
				double venusAge = (earthAge * 365) / 225; // 225 days = 1 year on Venus.
				return Math.round(venusAge * 100.0) / 100.0;
			case "earth":
				return Math.round(earthAge * 100.0) / 100.0;
			case "mars":
				double marsAge = (earthAge * 365) / 687; // 687 days = 1 year on Mars.
				return Math.round(marsAge * 100.0) / 100.0;
			case "jupiter":
				double jupiterAge = earthAge / 12; // 12 years = 1 year on Jupiter.
				return Math.round(jupiterAge * 100.0) / 100.0;
			case "saturn":
				double saturnAge = earthAge / 29.5; // 29.5 years = 1 year on Saturn.
				return Math.round(saturnAge * 100.0) / 100.0;
			case "uranus":
				double uranusAge = earthAge / 84; // 84 years = 1 year on Uranus.
				return Math.round(uranusAge * 100.0) / 100.0;
			case "neptune":
				double neptuneAge = earthAge / 165; // 165 years = 1 year on Neptune.
				return Math.round(neptuneAge * 100.0) / 100.0;
			case "pluto":
				double plutoAge = earthAge / 248; // 248 years = 1 year on Pluto.
				return Math.round(plutoAge * 100.0) / 100.0;
			default:
				return -1;
		}
	}

}
