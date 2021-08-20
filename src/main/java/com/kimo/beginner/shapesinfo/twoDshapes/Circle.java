package com.kimo.beginner.shapesinfo.twoDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        area = (Math.PI * Math.pow(radius, 2));

        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = (2 * Math.PI * radius);

        return perimeter;
    }

    @Override
    public String getType() {
        type = "CIRCLE";

        return type;
    }

    @Override
    public String getDefinition() {
        definition = "A circle is a shape consisting of all points in a plane that are at a given distance from a given point";

        return definition;
    }

    @Override
    public void dump() {
        PrintUtils.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + Math.round(getArea() * 100.0) / 100.0);
        System.out.println("Shape's Perimeter: " + Math.round(getPerimeter() * 100.0) / 100.0);
        System.out.println("Shape's Radius: " + getRadius());
        PrintUtils.printSeparator();
    }
}
