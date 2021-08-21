package com.kimo.beginner.shapesinfo.threeDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public class Sphere extends Shape {
    private double radius;

    public Sphere(double radius) {
        setRadius(radius);
        setVolume((Math.PI * Math.pow(getRadius(), 3) * 4) / 3);
        setSurfaceArea(4 * Math.PI * Math.pow(getRadius(), 2));
        setType("SPHERE");
        setDefinition("A sphere is a geometrical object in three-dimensional space that is the surface of a ball.");
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Radius: " + getRadius());
        PrintInterface.printSeparator();
    }
}
