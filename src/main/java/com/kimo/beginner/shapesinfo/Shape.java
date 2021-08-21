package com.kimo.beginner.shapesinfo;

import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public abstract class Shape implements PrintInterface {
    private double area;
    private double perimeter;
    private double volume;
    private double surfaceArea;

    private String definition;
    private String type;

    protected void setArea(double area) {
        this.area = area;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setVolume(double volume) {
        this.volume = volume;
    }

    protected void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    protected void setDefinition(String definition) {
        this.definition = definition;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public String getDefinition() {
        return definition;
    }

    public String getType() {
        return type;
    }

    public abstract void dump();
}
