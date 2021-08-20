package com.kimo.beginner.shapesinfo.twoDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Parallelogram extends Shape {
    private double height;
    private double base;

    public Parallelogram(double height, double base) {
        setHeight(height);
        setWidth(base);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return base;
    }

    public void setWidth(double width) {
        this.base = width;
    }

    @Override
    public double getArea() {
        area = (getWidth() * getHeight());

        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = (getWidth() * 2) + (getHeight() * 2);

        return perimeter;
    }

    @Override
    public String getType() {
        type = "PARALLELOGRAM";

        return type;
    }

    @Override
    public String getDefinition() {
        definition = "A parallelogram is a simple quadrilateral with two pairs of parallel sides.";

        return definition;
    }

    @Override
    public void dump() {
        PrintUtils.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimeter: " + getPerimeter());
        System.out.println("Shape's Base: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        PrintUtils.printSeparator();
    }
}