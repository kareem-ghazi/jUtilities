package com.kimo.beginner.stringifier;

public class Main {
	
	public static void main(String[] args) {
		Stringifier stringifier = new Stringifier("A# bUn5H@ 0f$ cHaRacteR5% 1n& h3R3!*");

		System.out.println(stringifier.reverseCharacters());
		System.out.println(stringifier.reverseWords());
		System.out.println(stringifier.isPalindrome());
		
		System.out.println(stringifier.getUppercaseLetters());
		System.out.println(stringifier.getLowercaseLetters());
		System.out.println(stringifier.getTotalLetters());
		System.out.println(stringifier.getNumbers());
		System.out.println(stringifier.getSpaces());
		System.out.println(stringifier.getOther());
	}

}
