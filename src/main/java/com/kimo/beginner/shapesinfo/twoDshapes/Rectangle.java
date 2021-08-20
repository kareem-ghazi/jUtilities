package com.kimo.beginner.shapesinfo.twoDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double length, double width) {
        setHeight(length);
        setWidth(width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
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
        PrintUtils.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimter: " + getPerimeter());
        System.out.println("Shape's Width: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        PrintUtils.printSeparator();
    }
}
