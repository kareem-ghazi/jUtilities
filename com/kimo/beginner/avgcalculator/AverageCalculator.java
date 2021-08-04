package com.kimo.beginner.avgcalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class AverageCalculator {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Double> numberList = new ArrayList<>();

	public static void main(String[] args) {
		printInstructions();
		System.out.print("-: ");
		String userInput = scan.nextLine();

		while (!userInput.equals("!break")) {
			userInput = addToList(userInput);
			
		}
		System.out.println("Average of the " + numberList.size() + " numbers you typed is: " + calculateAverage());
	}

	public static void printInstructions() {
		System.out.println("Average Calculator - Calculates the average of the numbers you enter.");
		System.out.println("Type '!break' whenever you are done.");

	}

	public static double calculateAverage() {
		double numbers = 0;
		for (int i = 0; i < numberList.size(); i++) {
			numbers = numbers + numberList.get(i);
		}

		double finalResult = numbers / numberList.size();
		return finalResult;

	}

	public static String addToList(String input) {
		numberList.add(Double.parseDouble(input));
		System.out.print("-: ");
		
		return scan.nextLine();

	}
}