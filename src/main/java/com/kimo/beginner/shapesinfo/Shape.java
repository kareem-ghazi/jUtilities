package com.kimo.beginner.shapesinfo;

public class Shape {
    private double height;
    private double width;

    protected double area;
    protected double perimeter;
    
    protected String definition;
    protected String type;

    public Shape(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getDefinition() {
        return definition;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public String getType() {
        return type;
    }

    public void dump() {
        System.out.println("This shape has no summary's yet.");
    }

}
