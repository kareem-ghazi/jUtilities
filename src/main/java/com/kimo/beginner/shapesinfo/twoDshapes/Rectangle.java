package com.kimo.beginner.shapesinfo.twoDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double length, double width) {
        setHeight(length);
        setWidth(width);
        setArea(getHeight() * getWidth());
        setPerimeter((2 * getHeight()) + (2 * getWidth()));
        setType("RECTANGLE");
        setDefinition("A rectangle is a quadrilateral with four right angles.");
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
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimter: " + getPerimeter());
        System.out.println("Shape's Width: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        PrintInterface.printSeparator();
    }
}
