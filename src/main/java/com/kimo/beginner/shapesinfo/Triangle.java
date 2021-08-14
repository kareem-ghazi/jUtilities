package com.kimo.beginner.shapesinfo;

public class Triangle extends Shape {

    public Triangle(double height, double base) {
        super(height, base);
    }

    public double getArea() {
        double area = (0.5 * getHeight() * getWidth());

        return area;
    }

    @Override
    public String getDefinition() {
        definition = "A triangle is a polygon with three edges and three vertices.";

        return definition;
    }

    @Override
    public String toString() {
        name = "Triangle";

        return name;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Name: " + toString());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Base: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("-----------------------------------------");
    }
}
