package com.kimo.agecalculator;

import java.util.Scanner;

public class User {
	Scanner scan = new Scanner(System.in);
	
	String username = "";
	String nationality = "";
	
	int birthYear = 0;
	int birthMonth = 0;
	int birthDay = 0;
	
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
		
	}
	
	public String getUsername() {
		return username;
		
	}
	
	public String getNationality() {
		return nationality;
		
	}
	
}
