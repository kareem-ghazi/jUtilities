package com.kimo.beginner.shapesinfo;

import java.util.Scanner;

import com.kimo.beginner.shapesinfo.menu.ShapeMenu;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Main implements PrintUtils {
	static ShapeMenu shapeMenu = new ShapeMenu();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		PrintUtils.printSeparator();
		System.out.println("ShapesInfo - Gets info about the shape using its attributes.");
		mainLoop();
	}

	public static void mainLoop() {
		int userInput = 0;

		do {
			PrintUtils.printSeparator();
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
		PrintUtils.printSeparator();
		System.out.println("1. 2D Shapes");
		System.out.println("2. 3D Shapes");
		System.out.println("3. Exit");
	}

	public static void selectShapeMenu(int userInput) {
		switch (userInput) {
			case 1:
				PrintUtils.printSeparator();
				shapeMenu.get2DShapeMenu();
				break;
			case 2:
				PrintUtils.printSeparator();
				shapeMenu.get3DShapeMenu();
				break;
			case 3:
				System.out.println("Exited program successfully.");
				PrintUtils.printSeparator();
				System.exit(0);
				break;
			default:
				PrintUtils.printSeparator();
				System.out.println("Invalid input.");
		}
	}
}
