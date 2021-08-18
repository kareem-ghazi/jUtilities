package com.kimo.beginner.shapesinfo;

public class Main {

	public static void main(String[] args) {
		Shape square = new Square(5);
		Shape triangle = new Triangle(10, 10);
		Shape parallelogram = new Parallelogram(10, 10);
		Shape rectangle = new Rectangle(10, 5);
		Shape circle = new Circle(5);
		Shape ellipse = new Ellipse(5, 8);
		Shape sphere = new Sphere(5);


		square.dump();
		triangle.dump();
		parallelogram.dump();
		rectangle.dump();
		circle.dump();
		ellipse.dump();
		sphere.dump();
	}

}
