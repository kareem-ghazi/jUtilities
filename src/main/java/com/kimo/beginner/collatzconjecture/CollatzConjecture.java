package com.kimo.beginner.collatzconjecture;

import java.util.Scanner;

public class CollatzConjecture {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Collatz Conjecture: ");
		System.out.print("Enter a number for the algorithm: ");
		int userInput = scan.nextInt();
		
		int i;
		for (i = 1; userInput != 1; i++) {
			if (userInput % 2 == 0) {
				userInput = userInput / 2;
			} else if (userInput % 2 != 0) {
				userInput = userInput * 3 + 1;
			}
		}
		
		System.out.println("Amount of steps to reach one: " + i);
	}

}
