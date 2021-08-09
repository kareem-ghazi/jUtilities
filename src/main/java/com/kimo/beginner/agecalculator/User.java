package com.kimo.beginner.agecalculator;

import java.time.LocalDate;

public class User {
	private String username;
	private String nationality;
	private LocalDate birthdate;

	// User constructor.
	public User(String username, String nationality, int birthYear, int birthMonth, int birthDay) {
		this.username = username;
		this.nationality = nationality;

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
