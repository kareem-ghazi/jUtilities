package com.kimo.beginner.shapesinfo;

public class Main {

	public static void main(String[] args) {
		Square square = new Square(5);
		Triangle triangle = new Triangle(10, 10);
		Parallelogram parallelogram = new Parallelogram(10, 10);
		Rectangle rectangle = new Rectangle(10, 5);

		square.dump();
		triangle.dump();
		parallelogram.dump();
		rectangle.dump();
	}

}
