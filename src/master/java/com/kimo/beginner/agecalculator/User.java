package com.kimo.beginner.agecalculator;

import java.time.LocalDate;

public class User {
	private String username;
	private String nationality;
	
	private int birthYear;
	private int birthMonth;
	private int birthDay;

	private LocalDate birthday;
	
	public void setName(String username) {
		this.username = username;
		
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
		
	}
	
	public void setBirthdate(int birthYear, int birthMonth, int birthDay) {
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		
		birthday = LocalDate.of(birthYear, birthMonth, birthDay);
	}
	
	public String getUsername() {
		return username;
		
	}
	
	public String getNationality() {
		return nationality;
		
	}
	
	public LocalDate getBirthdate() {
		return birthday;

	}

	public int getBirthMonth() {
		return birthMonth;
		
	}
	
	public int getBirthYear() {
		return birthYear;
		
	}
	
	public int getBirthDay() {
		return birthDay;
		
	}
	
}
