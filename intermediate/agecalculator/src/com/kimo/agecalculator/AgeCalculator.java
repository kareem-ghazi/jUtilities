package com.kimo.agecalculator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    private User user;

    private NumberFormat formatter;

    private static final LocalDate today = LocalDate.now();

    public AgeCalculator(User user) {
        this.user = user;
        this.formatter = NumberFormat.getInstance();
    }

    public Period getAge() {
        return Period.between(user.getBirthdate(), today);
    }

    public String getAgeInSeconds() {
        long ageInSeconds = ((this.getAge().getYears() * 31536000L) + (this.getAge().getMonths() * 2628002)
				+ (this.getAge().getDays() * 86400));

        return formatter.format(ageInSeconds);
    }

    public String getAgeInHours() {
		long ageInHours = ((this.getAge().getYears() * 31536000L) + (this.getAge().getMonths() * 2628002)
				+ (this.getAge().getDays() * 86400)) / 3600;

		return formatter.format(ageInHours);
	}

	// Calculates age in days.
	public String getAgeInDays() {
		long ageInDays = (((this.getAge().getYears() * 31536000L) + (this.getAge().getMonths() * 2628002)
				+ (this.getAge().getDays() * 86400)) / 86400);

		return formatter.format(ageInDays);
	}

    public Period getNextBirthday() {
        LocalDate nextBirthday = user.getBirthdate().withYear(today.getYear());

		if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
			nextBirthday = nextBirthday.plusYears(1);
		}

        return Period.between(today, nextBirthday);
    }

    public double getAgeOnPlanet(String planet) {
		double earthAge = this.getAge().getYears();

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
