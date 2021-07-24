package com.kimo.areaofshapes;

import java.util.Scanner;

public class Application {
	private static Scanner scan = new Scanner(System.in);
	
	public static void programLoop() {
		printSeparator();
		optionList();
		restartPrompt();
	}

	public static void printInstructions() {
		System.out.println("Choose one of the below: ");
		System.out.println("1. Calculate the area for a hexagon.");
		System.out.println("2. Calculate the area for a polygon.");
		System.out.println("3. Calculate the area for a triangle.");
		System.out.println("4. Calculate the area for a square.");
		
	}

	private static void restartPrompt() {
		scan.nextLine();
		System.out.print("Restart? (Y/N): ");

		while (true) {
			String prompt = scan.nextLine().toUpperCase();
			if (prompt.equals("Y")) {
				printSeparator();
				printInstructions();
				programLoop();
				printSeparator();
				break;
				
			} else if (prompt.equals("N")) {
				break;
				
			} else {
				System.err.println("Invalid input, please type 'Y' or 'N'.");
				System.out.print("-: ");
				
			}
		}
	}
	
	private static void optionList() {
		System.out.print("-: ");
		int userInput = scan.nextInt();

		switch (userInput) {
		case 1:
			System.out.print("Enter a length: ");
			int length = scan.nextInt();

			System.out.println(Shapes.hexagonArea(length));
			break;
		case 2:
			System.out.print("Enter the number of sides: ");
			int sides = scan.nextInt();
			System.out.print("Enter the length of one of the sides: ");
			int lengthOfSide = scan.nextInt();

			System.out.println(Shapes.polygonArea(sides, lengthOfSide));
			break;
		case 3:
			System.out.print("Enter the base: ");
			int base = scan.nextInt();
			System.out.print("Enter the height: ");
			int height = scan.nextInt();

			System.out.println(Shapes.triangleArea(base, height));
			break;
		case 4:
			System.out.print("Enter the base: ");
			int sidelength = scan.nextInt();

			System.out.println(Shapes.squareArea(sidelength));
			break;
		}
	}
	
	public static void printSeparator() {
		System.out.println("—————————————————————————————————————");
		
	}
}
