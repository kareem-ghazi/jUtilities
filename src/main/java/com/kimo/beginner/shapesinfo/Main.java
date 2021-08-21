package com.kimo.beginner.shapesinfo;

import java.util.Scanner;

import com.kimo.beginner.shapesinfo.menu.ShapeMenu;
import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public class Main implements PrintInterface {
	private static ShapeMenu shapeMenu = new ShapeMenu();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		PrintInterface.printSeparator();
		System.out.println("ShapesInfo - Gets info about the shape using its attributes.");
		mainLoop();
	}

	public static void mainLoop() {
		int userInput = 0;

		do {
			PrintInterface.printSeparator();
			printCommandList();

			userInput = 0;

			System.out.print("-: ");
			try {
				userInput = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
			}

			selectShapeMenu(userInput);
		} while (true);
	}

	public static void printCommandList() {
		System.out.println(">>> Shape Types <<<");
		PrintInterface.printSeparator();
		System.out.println("1. 2D Shapes");
		System.out.println("2. 3D Shapes");
		System.out.println("3. Exit");
	}

	public static void selectShapeMenu(int userInput) {
		switch (userInput) {
			case 1:
				PrintInterface.printSeparator();
				shapeMenu.get2DShapeMenu();
				break;
			case 2:
				PrintInterface.printSeparator();
				shapeMenu.get3DShapeMenu();
				break;
			case 3:
				System.out.println("Exited program successfully.");
				PrintInterface.printSeparator();
				System.exit(0);
				break;
			default:
				PrintInterface.printSeparator();
				System.out.println("Invalid input.");
		}
	}
}
