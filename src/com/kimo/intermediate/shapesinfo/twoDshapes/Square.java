package com.kimo.intermediate.shapesinfo.twoDshapes;

import com.kimo.intermediate.shapesinfo.Shape;
import com.kimo.intermediate.shapesinfo.utils.PrintInterface;

public class Square extends Shape {
    private double sideLength;

    /**
     * Main constructor for the Square class. Takes in side length of a square as a parameter.
     * @param sideLength - Side length of a square.
     */
    public Square(double sideLength) {
        setSideLength(sideLength);
        setArea(Math.pow(sideLength, 2));
        setPerimeter((sideLength * 2) + (sideLength * 2));
        setType("SQUARE");
        setDefinition("A square is a regular quadrilateral with four equal straight sides and four right angles.");
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimter: " + getPerimeter());
        System.out.println("Shape's Width: " + getSideLength());
        System.out.println("Shape's Height: " + getSideLength());
        PrintInterface.printSeparator();
    }
}