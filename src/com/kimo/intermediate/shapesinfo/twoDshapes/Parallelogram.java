package com.kimo.intermediate.shapesinfo.twoDshapes;

import com.kimo.intermediate.shapesinfo.Shape;
import com.kimo.intermediate.shapesinfo.utils.PrintInterface;

public class Parallelogram extends Shape {
    private double height;
    private double base;

    /**
     * Main constructor for the Parellogram class. Takes in height and base of a parallelogram as parameters.
     * @param height - Height of a parallelogram.
     * @param base - Base of a parallelogram.
     */
    public Parallelogram(double height, double base) {
        setHeight(height);
        setBase(base);
        setArea((base * height));
        setPerimeter((base * 2) + (height * 2));
        setType("PARALLELOGRAM");
        setDefinition("A parallelogram is a simple quadrilateral with two pairs of parallel sides.");
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

    public void setBase(double width) {
        this.base = width;
    }

    @Override
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimeter: " + getPerimeter());
        System.out.println("Shape's Base: " + getBase());
        System.out.println("Shape's Height: " + getHeight());
        PrintInterface.printSeparator();
    }
}