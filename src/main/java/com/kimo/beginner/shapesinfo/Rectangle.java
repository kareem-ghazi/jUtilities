package com.kimo.beginner.shapesinfo;

public class Rectangle extends TwoDShape {

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
    }
    
    @Override
    public double getArea() {
        area = getHeight() * getWidth();

        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = (2 * getHeight()) + (2 * getWidth());

        return perimeter;
    }

    @Override
    public String getDefinition() {
        definition = "A rectangle is a quadrilateral with four right angles.";

        return definition;
    }

    @Override
    public String getType() {
        type = "RECTANGLE";

        return type;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimter: " + getPerimeter());
        System.out.println("Shape's Width: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("-----------------------------------------");
    }
}
