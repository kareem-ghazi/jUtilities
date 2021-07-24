package com.kimo.guessthenumber;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();

	public static void main(String[] args) {
		int definedGuess = rand.nextInt(3) + 1;
		int guesses = 5;
		int i;
		for (i = 0; i < 5; i++) {
			System.out.print("-: ");
			int userGuess = scan.nextInt();
			if (userGuess > definedGuess && i != guesses - 1) {
				System.out.println("You guessed wrongly, the number is lower than " + userGuess + ".");
			} else if (userGuess < definedGuess && i != guesses - 1) {
				System.out.println("You guessed wrongly, the number is greater than " + userGuess + ".");
			} else if (userGuess == definedGuess) {
				System.out.println("Congratulations, you guessed the correct number!");
				break;
			}
			
		}
		
		if (i == 5) {
			System.out.println("Unfortunately, you ran out of guesses :(.");
			System.out.println("The correct number was: " + definedGuess);
		}
	}
}
