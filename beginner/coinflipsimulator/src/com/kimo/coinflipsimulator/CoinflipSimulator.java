package com.kimo.coinflipsimulator;

import java.util.Random;
import java.util.Scanner;

public class CoinflipSimulator {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("----------------------------");
		System.out.print("Enter the amount of coin flip iterations: ");
		double userInput = scan.nextInt();

		printCoinflipResult(userInput);
	}

	public static void printCoinflipResult(double iterations) {
	    int heads = 0;
		int tails = 0;

		Random rand = new Random();
		int coinflip;

		long start = System.currentTimeMillis(); // Starts a timer
		for (int i = 0; i < iterations; i++) { // Loops through the iterations each time with a random value. 0 for heads, 1 for tails.
			coinflip = rand.nextInt(2);
			
			if (coinflip == 0) {
				heads++;
			} else if (coinflip == 1) {
				tails++;
			}
			
		}

		// Calculates percentages
		double headPercentage = Math.round((heads * 100 / iterations) * 1000.0) / 1000.0;
		double tailPercentage = Math.round((tails * 100 / iterations) * 1000.0) / 1000.0;
		
		System.out.println("----------------------------");
		System.out.println("Results of " + iterations + " iterations: ");
		System.out.println("Heads: " + heads + " - " + headPercentage + "%");
		System.out.println("Tails: " + tails + " - " + tailPercentage + "%");
		System.out.println("----------------------------");
		System.out.println("TIME TAKEN: " + (System.currentTimeMillis() - start) + "ms");
		System.out.println("----------------------------");
	}
}
