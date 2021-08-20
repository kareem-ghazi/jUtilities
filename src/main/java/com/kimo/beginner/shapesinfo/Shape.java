package com.kimo.beginner.shapesinfo;

import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Shape implements PrintUtils {
    protected double area;
    protected double perimeter;
    protected double volume;    
    protected double surfaceArea;

    protected String definition;
    protected String type;

    public String getDefinition() {
        return definition;
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

    public String getType() {
        return type;
    }

    public void dump() {
        System.out.println("This shape has no summaries yet.");
    }
}
