package com.kimo.sumofdigits;

import java.util.Scanner;

public class SumOfDigits {
	private Scanner scan = new Scanner(System.in);
	private String value;

	// Calculates the sum of the digits in a number.
	private void calculateSumOfDigits(String number) {
		int finalResult = 0;
		for (int i = 0; i < number.length(); i++) {
			finalResult += Character.getNumericValue(number.charAt(i));
			
		}
		
		printSeparator();
		System.out.println("The sum of the digits is: " + finalResult);
		printSeparator();
		// Enter main loop again.
		mainLoop();
	}
	
	// The main loop for the program.
	public boolean mainLoop() {
		getInput();
		// Runs if the user input is not equal to the break command.
		while (!value.equals("!break")) {
			calculateSumOfDigits(value);
		}
		
		return false;
	}
	
	// Prints instructions on start.
	public void printInstructions() {
		System.out.println("SumOfDigits - Calculate the sum of digits in a number.");
		System.out.println("Type 'break' to exit.");
		
	}
	
	// Gets input from the user.
	public void getInput() {
		System.out.print("-: ");
		value = scan.next();
		
	}
	
	// Prints a separator.
	private void printSeparator() {
		System.out.println("—————————————————————————————————————");
		
	}
}
