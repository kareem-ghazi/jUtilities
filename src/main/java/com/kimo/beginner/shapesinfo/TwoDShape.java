package com.kimo.beginner.shapesinfo;

public class TwoDShape {
    protected double height;
    protected double width;
    protected double radius;

    protected double area;
    protected double perimeter;
    
    protected String definition;
    protected String type;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getRadius() {
        return radius;
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
