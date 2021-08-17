package com.kimo.beginner.shapesinfo;

public class Square extends TwoDShape {

    public Square(double sideLength) {
        setHeight(sideLength);
        setWidth(sideLength);
    }

    @Override
    public double getArea() {
        area = getWidth() * getHeight();

        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = (getWidth() * 2) + (getHeight() * 2);
        
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
        System.out.println("Shape's Width: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("-----------------------------------------");
    }
}