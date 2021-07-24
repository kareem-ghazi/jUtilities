/* PROJECT EXPLANATION: NUMBER CHECKER
 * 
 */

package com.kimo.numberchecker;

import java.util.Scanner;

public class NumberChecker {

	public static void main(String[] args) {
		try (Scanner userInput = new Scanner(System.in)) {
			System.out.println("Enter your number: ");
			long definedNumber = userInput.nextLong();

			if (definedNumber % 2 == 0) {
				System.out.println(definedNumber + " is an even number.");
			} else {
				System.out.println(definedNumber + " is an odd number.");
			}
		}
	}
}
