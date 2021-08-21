package com.kimo.beginner.shapesinfo.twoDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public class Triangle extends Shape {
    private double height;
    private double base;

    public Triangle(double height, double base) {
        setHeight(height);
        setBase(base);
        setArea((0.5 * getHeight() * getBase()));
        setType("TRIANGLE");
        setDefinition("A triangle is a polygon with three edges and three vertices.");
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Base: " + getBase());
        System.out.println("Shape's Height: " + getHeight());
        PrintInterface.printSeparator();
    }
}
