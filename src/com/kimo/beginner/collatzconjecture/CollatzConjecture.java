package com.kimo.beginner.collatzconjecture;

import java.util.Scanner;

public class CollatzConjecture {
	private static Scanner scan = new Scanner(System.in);
	private static int i = 0; // Steps counter

	public static void main(String[] args) {
		System.out.println("Collatz Conjecture - Algorithm");
		System.out.println("--------------------------------------");
		System.out.print("Enter a number for the algorithm: ");

		// Main loop.
		while (true) {
			String userInput = scan.nextLine();

			if (userInput.equals("!q")) {
				System.out.println("Exited program successfully.");
				System.out.println("--------------------------------------");
				break;
			}

			i = 0;

			if (isNumeric(userInput) && Integer.parseInt(userInput) != 0) {
				System.out.println("Amount of steps to reach 1: " + collatzConjecture(Integer.parseInt(userInput)));
			} else {
				System.out.println("Invalid input.");
			}

			System.out.print("-: ");
		}

	}

	// Collatz Conjecture for the specified number.
	// --------------------------------------
	// If the number is even, it is divided by 2.
	// If the number is odd, it is multiplied by 3 and then added with 1.
	private static int collatzConjecture(int number) {
		if (number != 1) {
			if (number % 2 == 0) {
				number = number / 2;
				i++;
			} else if (number % 2 != 0) {
				number = number * 3 + 1;
				i++;
			}
		} else if (number == 1) {
			return i;
		}

		return collatzConjecture(number);
	}

	// Checks if the input is numeric.
	private static boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
