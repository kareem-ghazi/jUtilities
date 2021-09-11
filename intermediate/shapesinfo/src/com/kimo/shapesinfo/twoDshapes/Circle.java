package com.kimo.shapesinfo.twoDshapes;

import com.kimo.shapesinfo.Shape;
import com.kimo.shapesinfo.utils.PrintInterface;

public class Circle extends Shape {
    private double radius;

    /**
     * Main constructor for the Circle class. Takes in radius of a circle as a parameter.
     * @param radius - Radius of a circle.
     */
    public Circle(double radius) {
        setRadius(radius);
        setArea(Math.PI * Math.pow(radius, 2));
        setPerimeter(2 * Math.PI * radius);
        setType("CIRCLE");
        setDefinition(
                "A circle is a shape consisting of all points in a plane that are at a given distance from a given point.");
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + Math.round(getArea() * 100.0) / 100.0);
        System.out.println("Shape's Perimeter: " + Math.round(getPerimeter() * 100.0) / 100.0);
        System.out.println("Shape's Radius: " + getRadius());
        PrintInterface.printSeparator();
    }
}
