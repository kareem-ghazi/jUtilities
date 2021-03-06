package com.kimo.stringifier;

import java.util.ArrayList;
import java.util.Collections;

public class Stringifier {
	private String string;

	private int uppercaseLetters = 0;
	private int lowercaseLetters = 0;

	private int numbers = 0;
	private int spaces = 0;
	private int other = 0;

	/**
	 * Creates a new Stringifier object.
	 * @param string A string.
	 */
	public Stringifier(String string) {
		this.string = string;
		countCharacters();
	}

	/**
	 * Reverses the characters of a string.
	 * @return The reversed characters of a string.
	 */
	public String reverseCharacters() {
		StringBuilder stringBuilder = new StringBuilder(string);
		String reversedString = stringBuilder.reverse().toString();

		return reversedString;
	}

	/**
	 * Reverses the words of a string.
	 * @return The reversed words of a string.
	 */
	public String reverseWords() {
		ArrayList<String> stringArray = new ArrayList<>();
		String reversedString = "";

		Collections.addAll(stringArray, string.split(" "));
		Collections.reverse(stringArray);

		for (String string : stringArray) {
			reversedString += string + " ";	
		}

		return reversedString;
	}

	/**
	 * Checks whether the string is a palindrome or not.
	 * @return Whether the string is a palindrome or not.
	 */
	public boolean isPalindrome() {
		return string.equals(reverseCharacters());
	}

	/**
	 * Counts the characters of a string.
	 */
	private void countCharacters() {
		char[] charArray = string.toCharArray();
		
		for (char character : charArray) {
			if (Character.isSpaceChar(character)) {
				spaces++;
			} else if (Character.isDigit(character)) {
				numbers++;
			} else if (Character.isLetter(character)) {
				if (Character.isUpperCase(character)) {
					uppercaseLetters++;
				} else if (Character.isLowerCase(character)) {
					lowercaseLetters++;
				}
			} else {
				other++;
			}
		}
	}

	public int getUppercaseLetters() {
		return uppercaseLetters;
	}

	public int getLowercaseLetters() {
		return lowercaseLetters;
	}

	public int getTotalLetters() {
		return lowercaseLetters + uppercaseLetters;
	}

	public int getNumbers() {
		return numbers;
	}

	public int getSpaces() {
		return spaces;
	}

	public int getOther() {
		return other;
	}

	public String getString() {
		return string;
	}
}
