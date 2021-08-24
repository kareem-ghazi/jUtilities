package com.kimo.intermediate.shapesinfo.threeDshapes;

import com.kimo.intermediate.shapesinfo.Shape;
import com.kimo.intermediate.shapesinfo.utils.PrintInterface;

public class Sphere extends Shape {
    private double radius;

    /**
     * Main constructor for the Sphere class. Takes in radius of a sphere1 as a parameter.
     * @param radius - Radius of a sphere.
     */
    public Sphere(double radius) {
        setRadius(radius);
        setVolume((Math.PI * Math.pow(radius, 3) * 4) / 3);
        setSurfaceArea(4 * Math.PI * Math.pow(radius, 2));
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
