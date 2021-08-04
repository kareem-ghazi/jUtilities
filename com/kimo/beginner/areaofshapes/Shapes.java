package com.kimo.beginner.areaofshapes;

public class Shapes {
	
	public static double hexagonArea(int length) {
		double hexagonArea = (6 * Math.pow(length, 2) / (4 * Math.tan(Math.PI / 6)));
		return hexagonArea;
		
	}
	
	public static double polygonArea(int sides, int length) {
		double polygonArea = (sides * Math.pow(length, 2)) / (4 * Math.tan(Math.PI / sides));
		return polygonArea;
		
	}
	
	public static double triangleArea(int base, int height) {
		double triangleArea = 0.5 * base * height;
		return triangleArea;
		
	}
	
	public static double squareArea(int sidelength) {
		double squareArea = sidelength * sidelength;
		return squareArea;
		
	}
}
