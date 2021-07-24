package com.kimo.coinflipsimulator;

import java.util.Random;
import java.util.Scanner;

public class CoinFlipSimulator {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter the amount of coin flip iterations: ");
		double userInput = scan.nextDouble();
		int heads = 0;
		int tails = 0;
		
		for (int i = 0; i < userInput; i++) {
			Random rand = new Random();
			int coinFlip = rand.nextInt(2);
			
			if (coinFlip == 0) {
				heads++;
			} else if (coinFlip == 1) {
				tails++;
			}
			
		}
		
		double headPercentage = Math.round((heads * 100 / userInput) * 1000.0) / 1000.0;
		double tailPercentage = Math.round((tails * 100 / userInput) * 1000.0) / 1000.0;
		
		System.out.println("Results of " + Math.round(userInput) + " iterations: ");
		System.out.println("Heads: " + heads + " — " + headPercentage + "%");
		System.out.println("Tails: " + tails + " — " + tailPercentage + "%");
		
	}

}
