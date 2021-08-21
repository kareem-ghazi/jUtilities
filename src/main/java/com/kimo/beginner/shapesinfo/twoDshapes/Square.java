package com.kimo.beginner.shapesinfo.twoDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        setSideLength(sideLength);
        setArea(Math.pow(getSideLength(), 2));
        setPerimeter((getSideLength() * 2) + (getSideLength() * 2));
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