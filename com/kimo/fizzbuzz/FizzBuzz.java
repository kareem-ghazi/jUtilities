/* PROJECT EXPLANATION: FIZZBUZZ
 * 
 * Write a program that prints the numbers from 1 to 100. But for multiples of three print 
 * “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which 
 * are multiples of both three and five print “FizzBuzz”.
 * 
 */

package com.kimo.fizzbuzz;

import java.util.Scanner;

public class FizzBuzz {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		printInstructions();
		mainLoop();
	}

	public static void mainLoop() {
		while (true) {
			System.out.print("-: ");
			String userInput = readInput();
			int definedNumber = 0;
			try {
				definedNumber = parseInt(userInput);
			} catch (Exception e) {
				System.out.println("god");
			}
			
			if (definedNumber % 3 == 0 && definedNumber % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (definedNumber % 5 == 0) {
				System.out.println("Buzz");
			} else if (definedNumber % 3 == 0) {
				System.out.println("Fizz");
			} else if (userInput.equals("!exit")) {
				break;
			} else {
				System.err.println(userInput + " doesn't meet any of the conditions.");
			}
		}
	}

	public static void printInstructions() {
		System.out.println("FizzBuzz");
		System.out.println("If a number is a multiple of 3, prints out 'Fizz'.");
		System.out.println("If a number is a multiple of 5, prints out 'Buzz'.");
		System.out.println("If a number is a multiple of both 3 and 5, prints out 'FizzBuzz'.");
	}

	public static String readInput() {
		return scan.nextLine();
		
	}
	
	public static int parseInt(String string) {
		return Integer.parseInt(string);
	}
}
