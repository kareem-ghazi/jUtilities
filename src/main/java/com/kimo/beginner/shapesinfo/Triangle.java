package com.kimo.beginner.shapesinfo;

public class Triangle extends TwoDShape {

    public Triangle(double height, double base) {
        setHeight(height);
        setWidth(base);
    }

    @Override
    public double getArea() {
        area = (0.5 * getHeight() * getWidth());

        return area;
    }

    @Override
    public String getDefinition() {
        definition = "A triangle is a polygon with three edges and three vertices.";

        return definition;
    }

    @Override
    public String getType() {
        type = "TRIANGLE";

        return type;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Base: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("-----------------------------------------");
    }
}
