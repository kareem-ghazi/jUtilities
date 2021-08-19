package com.kimo.beginner.shapesinfo;

import java.util.Scanner;

import com.kimo.beginner.shapesinfo.threeDshapes.Cone;
import com.kimo.beginner.shapesinfo.threeDshapes.Cube;
import com.kimo.beginner.shapesinfo.threeDshapes.Cuboid;
import com.kimo.beginner.shapesinfo.threeDshapes.Cylinder;
import com.kimo.beginner.shapesinfo.threeDshapes.Sphere;
import com.kimo.beginner.shapesinfo.twoDshapes.Circle;
import com.kimo.beginner.shapesinfo.twoDshapes.Ellipse;
import com.kimo.beginner.shapesinfo.twoDshapes.Parallelogram;
import com.kimo.beginner.shapesinfo.twoDshapes.Rectangle;
import com.kimo.beginner.shapesinfo.twoDshapes.Square;
import com.kimo.beginner.shapesinfo.twoDshapes.Triangle;

public class Main {
	static ShapeMenu shapeMenu = new ShapeMenu();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Shape square = new Square(5);
		Shape triangle = new Triangle(10, 10);
		Shape parallelogram = new Parallelogram(10, 10);
		Shape rectangle = new Rectangle(10, 5);
		Shape circle = new Circle(5);
		Shape ellipse = new Ellipse(5, 8);

		Shape sphere = new Sphere(5);
		Shape cylinder = new Cylinder(5, 5);
		Shape cone = new Cone(5, 8);
		Shape cube = new Cube(5);
		Shape cuboid = new Cuboid(10, 10, 10);

		printSeparator();
		System.out.println("ShapesInfo - Gets info about the shape using its attributes.");
		mainLoop();
	}

	public static void mainLoop() {
		int userInput = 0;

		do {
			printSeparator();
			printCommandList();

			userInput = 0;

			System.out.print("-: ");
			try {
				userInput = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
			}

			selectShapeType(userInput);
		} while (true);
	}

	public static void printSeparator() {
		System.out.println("-------------------------------");
	}

	public static void printCommandList() {
		System.out.println("### Shape Types ###");
		printSeparator();
		System.out.println("1. 2D Shapes");
		System.out.println("2. 3D Shapes");
		System.out.println("3. Exit");
	}

	public static void selectShapeType(int userInput) {
		switch (userInput) {
			case 1:
				shapeMenu.get2DShapeMenu();
				break;
			case 2:
				printSeparator();
				shapeMenu.get3DShapeMenu();
				break;
			case 3:
				System.out.println("Exited program successfully.");
				printSeparator();
				System.exit(0);
				break;
			default:
				printSeparator();
				System.out.println("Invalid input.");
		}
	}
}
