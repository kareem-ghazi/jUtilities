package com.kimo.agecalculator;

import java.time.LocalDate;

public class User {
	private String username;
	private String nationality;
	private LocalDate birthdate;

	public User(String username, String nationality, LocalDate birthdate) {
		this.username = username;
		this.nationality = nationality;
		this.birthdate = birthdate;
	}

	public User(String username, String nationality, int birthYear, int birthMonth, int birthDay) {
		this(username, nationality, LocalDate.of(birthYear, birthMonth, birthDay));
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
