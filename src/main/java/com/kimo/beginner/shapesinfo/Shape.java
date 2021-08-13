package com.kimo.beginner.shapesinfo;

public class Shape {
    protected double height;
    protected double width;
    protected String definition;

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
        definition = "This shape has no definitions yet.";

        return definition;
    }
}
