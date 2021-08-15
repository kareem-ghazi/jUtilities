package com.kimo.beginner.shapesinfo;

public class Parallelogram extends Shape {

    public Parallelogram(double height, double base) {
        super(height, base);
    }

    public double getArea() {
        double area = (getWidth() * getHeight());

        return area;
    }

    public double getPerimeter() {
        double perimeter = (getWidth() * 2) + (getHeight() * 2);

        return perimeter;
    }

    @Override
    public String toString() {
        name = "Parallelogram";

        return name;
    }

    @Override
    public String getDefinition() {
        definition = "A parallelogram is a simple quadrilateral with two pairs of parallel sides.";

        return definition;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Name: " + toString());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimeter: " + getPerimeter());
        System.out.println("Shape's Base: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("-----------------------------------------");
    }

}