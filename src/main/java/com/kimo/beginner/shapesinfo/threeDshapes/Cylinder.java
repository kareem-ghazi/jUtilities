package com.kimo.beginner.shapesinfo.threeDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Cylinder extends Shape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        setRadius(radius);
        setHeight(height);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        volume = (Math.PI * Math.pow(getRadius(), 2) * getHeight());

        return volume;
    }

    @Override
    public double getSurfaceArea() {
        surfaceArea = (2 * Math.PI * getRadius() * (getRadius() + getHeight()));

        return surfaceArea;
    }

    @Override
    public String getDefinition() {
        definition = "A cylinder is a three-dimensional solid that holds two parallel bases joined by a curved surface, at a fixed distance.";

        return definition;
    }

    @Override
    public String getType() {
        type = "CYLINDER";

        return type;
    }

    @Override
    public void dump() {
        PrintUtils.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Radius: " + getRadius());
        System.out.println("Shape's Height: " + getHeight());
        PrintUtils.printSeparator();
    }
}
