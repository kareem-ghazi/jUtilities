package com.kimo.intermediate.agecalculator;

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
