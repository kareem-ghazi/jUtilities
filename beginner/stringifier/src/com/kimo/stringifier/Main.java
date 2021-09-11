package com.kimo.stringifier;

public class Main {
	
	public static void main(String[] args) {
		Stringifier stringifier = new Stringifier("A# bUn5H@ 0f$ cHaRacteR5% 1n& h3R3!*");

		System.out.println("Original String: " + stringifier.getString());
		System.out.println();
		System.out.println("Reversed Characters of the String: " + stringifier.reverseCharacters());
		System.out.println("Reversed Words of the String: " + stringifier.reverseWords());
		System.out.println("Is Palindrome: " + stringifier.isPalindrome());
		System.out.println();
		System.out.println("Total Letter Count: " + stringifier.getTotalLetters());
		System.out.println(" - Uppercase Letter Count: " + stringifier.getUppercaseLetters());
		System.out.println(" - Lowercase Letter Count: " + stringifier.getLowercaseLetters());
		System.out.println("Digit Count: " + stringifier.getNumbers());
		System.out.println("Space Count: " + stringifier.getSpaces());
		System.out.println("Other Count: " + stringifier.getOther());
	}
}
