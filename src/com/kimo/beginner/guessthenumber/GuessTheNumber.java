package com.kimo.beginner.guessthenumber;

import java.util.Random;

import com.kimo.beginner.guessthenumber.utils.InputUtils;
import com.kimo.beginner.guessthenumber.utils.PrintUtils;

public class GuessTheNumber {
	private Random rand = new Random();

	private int minimumGuessRange = 1;
	private int maximumGuessRange = 25;

	private int guesses = 0;
	private int correctNumber = 0;

	private boolean hasPlayed = false;

	public void play() {
		correctNumber = rand.nextInt(maximumGuessRange) + minimumGuessRange;
		guesses = 0;
		System.out.println("Guess a number between " + minimumGuessRange + " and " + maximumGuessRange);

		while (true) {
			System.out.print("-: ");
			int userGuess = InputUtils.getCaughtInput();

			if (userGuess > correctNumber) {
				System.out.println("Wrong, the number is lower than " + userGuess + ".");
			} else if (userGuess < correctNumber) {
				System.out.println("Wrong, the number is greater than " + userGuess + ".");
			} else if (userGuess == correctNumber) {
				System.out.println("Congratulations, you guessed the correct number: " + correctNumber);
				hasPlayed = true;
				break;
			}

			guesses++;
		}

	}

	public void setGuessRange(int minimumGuessRange, int maximumGuessRange) {
		this.minimumGuessRange = minimumGuessRange;
		this.maximumGuessRange = maximumGuessRange;
	}

	public void printLastSession() {
		if (hasPlayed) {
			System.out.println("Number of Guesses: " + guesses);
			System.out.println("Correct number: " + correctNumber);
		} else if (!hasPlayed) {
			System.out.println("You have not played a game yet.");
		}
		PrintUtils.printSeparator();
	}
}
