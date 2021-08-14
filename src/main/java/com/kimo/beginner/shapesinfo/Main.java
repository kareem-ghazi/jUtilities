package com.kimo.beginner.shapesinfo;

public class Main {

	public static void main(String[] args) {
		Square square = new Square(5);
		Triangle triangle = new Triangle(10, 10);

		square.dump();
		triangle.dump();
	}

	public static void printSeparator() {
		System.out.println("-----------------------------------------");
	}

}
