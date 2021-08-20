package com.kimo.beginner.shapesinfo.twoDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Triangle extends Shape {
    private double height;
    private double base;

    public Triangle(double height, double base) {
        setHeight(height);
        setBase(base);
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
    public double getArea() {
        area = (0.5 * getHeight() * getBase());

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
        PrintUtils.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Base: " + getBase());
        System.out.println("Shape's Height: " + getHeight());
        PrintUtils.printSeparator();
    }
}
