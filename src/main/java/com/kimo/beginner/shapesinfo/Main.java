package com.kimo.beginner.shapesinfo;

public class Main {

	public static void main(String[] args) {
		Square square = new Square(4);

		System.out.println(square.getDefinition());
		System.out.println(square.getArea());
		System.out.println(square.getPerimeter());
		System.out.println();
		System.out.println(square.getWidth());
		System.out.println(square.getHeight());
	}

}
