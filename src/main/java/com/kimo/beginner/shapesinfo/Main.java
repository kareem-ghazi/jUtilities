package com.kimo.beginner.shapesinfo;

public class Main {

	public static void main(String[] args) {
		TwoDShape square = new Square(5);
		TwoDShape triangle = new Triangle(10, 10);
		TwoDShape parallelogram = new Parallelogram(10, 10);
		TwoDShape rectangle = new Rectangle(10, 5);
		TwoDShape circle = new Circle(5);

		square.dump();
		triangle.dump();
		parallelogram.dump();
		rectangle.dump();
		circle.dump();
	}

}
