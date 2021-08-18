package com.kimo.beginner.shapesinfo;

public class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        setSideLength(sideLength);
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        area = Math.pow(getSideLength(), 2);

        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = (getSideLength() * 2) + (getSideLength() * 2);
        
        return perimeter;
    }

    @Override
    public String getDefinition() {
        definition = "A square is a regular quadrilateral with four equal straight sides and four right angles.";

        return definition;
    }

    @Override
    public String getType() {
        type = "SQUARE";

        return type;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + getArea());
        System.out.println("Shape's Perimter: " + getPerimeter());
        System.out.println("Shape's Width: " + getSideLength());
        System.out.println("Shape's Height: " + getSideLength());
        System.out.println("-----------------------------------------");
    }
}