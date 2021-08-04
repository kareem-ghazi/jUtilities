package com.kimo.beginner.avgcalculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Simplified {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("-: ");
		String userInput = scan.nextLine();
		ArrayList<Double> numberList = new ArrayList<>();
		
		while (!userInput.equals("!break")) {
			numberList.add(Double.parseDouble(userInput));
			System.out.print("-: ");
			userInput = scan.nextLine();
		}
		
		double numbers = 0;
		for (int i = 0; i < numberList.size(); i++) {
			numbers = numbers + numberList.get(i);
		}
		
		double finalResult = numbers / numberList.size();
		System.out.println("Average of the " + numberList.size() + " numbers you typed is: " + finalResult);
		
	}
}
