package com.kimo.beginner.shapesinfo;

public class Square extends Shape {

    public Square(double sideLength) {
        super(sideLength, sideLength);
    }

    public double getArea() {
        double area = getWidth() * getHeight();

        return area;
    }

    public double getPerimeter() {
        double perimeter = (getWidth() * 2) + (getHeight() * 2);

        return perimeter;
    }

    @Override
    public String getDefinition() {
        definition = "A square is a regular quadrilateral with four equal straight sides and four right angles.";

        return definition;
    }

    @Override
    public String toString() {
        name = "Square";

        return name;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Name: " + toString());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimter: " + getPerimeter());
        System.out.println("Shape's Width: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("-----------------------------------------");
    }

}