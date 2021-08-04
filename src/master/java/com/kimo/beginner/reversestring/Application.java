package com.kimo.beginner.reversestring;

import java.util.Scanner;

public class Application {
	Scanner userInput = new Scanner(System.in);
	String definedString;

	// Main function for reversing the string.
	private String reverseString(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] charArray = string.toCharArray();
		for (int i = string.length() - 1; i >= 0; i--) {
			stringBuilder.append(charArray[i]);
			
		}
		
		return stringBuilder.toString();
	}

	// Processes the output and prints it out.
	private void processInput() {
		
		printSeparator();
		System.out.println("Reversed String: " + reverseString(definedString));
		printSeparator();
		
		countCharacters(definedString);
		isPalindrome();
		programLoop();
		
	}

	// Main program loop.
	public boolean programLoop() {
		System.out.print("-: ");
		definedString = userInput.nextLine();
		
		// If the input isn't the break command, it processes and prints out the results.
		while (!definedString.equals("!break")) {
			processInput();
			
		}
		
		return false;
		
	}

	// Prints starting instructions.
	public void printInstructions() {
		System.out.println("StringModifier - Reverses a string and returns information about it.");
		System.out.println("Type '!break' to exit");
		
	}

	// Counts the amount of characters in the reversed string.
	private void countCharacters(String string) {
		char[] charArray = string.toCharArray();
		int letters = 0;
		int numbers = 0;
		int spaces = 0;
		int other = 0;

		for (int i = 0; i < string.length(); i++) {
			if (Character.isSpaceChar(charArray[i])) {
				spaces++;

			} else if (Character.isDigit(charArray[i])) {
				numbers++;

			} else if (Character.isLetter(charArray[i])) {
				letters++;

			} else {
				other++;

			}
		}
		
		System.out.println("Spaces: " + spaces);
		System.out.println("Numbers: " + numbers);
		System.out.println("Letters: " + letters);
		System.out.println("Other: " + other);
	}
	
	// Adds a separating line.
	public void printSeparator() {
		System.out.println("�������������������������������������");
		
	}
	
	// Checks if the string is a palindrome.
	public void isPalindrome() {
		
		if (definedString.equals(reverseString(definedString))) {
			System.out.println("Is a Palindrome: Yes");
		} else {
			System.out.println("Is a Palindrome: No");
		}
	}

}

