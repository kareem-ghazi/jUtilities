package com.kimo.intermediate.shapesinfo.threeDshapes;

import com.kimo.intermediate.shapesinfo.Shape;
import com.kimo.intermediate.shapesinfo.utils.PrintInterface;

public class Cone extends Shape {
    private double height;
    private double radius;

    private double slantedHeight;
    private double curvedSurfaceArea;

    /**
     * Main constructor for the Cone class. Takes in radius and height of a cone as parameters.
     * @param radius - Radius of a cone.
     * @param height - Height of a cone.
     */
    public Cone(double radius, double height) {
        setHeight(height);
        setRadius(radius);
        setSlantedHeight(Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
        setSurfaceArea((Math.PI * radius * (slantedHeight + radius)));
        setCurvedSurfaceArea((Math.PI * radius * slantedHeight));
        setVolume((Math.PI * Math.pow(radius, 2) * height) / 3);
        setType("CONE");
        setDefinition("A cone is a three-dimensional geometric shape that tapers smoothly from a flat base to a point called the apex or vertex.");
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getSlantedHeight() {
        return slantedHeight;
    }

    public void setSlantedHeight(double slantHeight) {
        this.slantedHeight = slantHeight;
    }

    public double getCurvedSurfaceArea() {
        return curvedSurfaceArea;
    }

    public void setCurvedSurfaceArea(double curvedSurfaceArea) {
        this.curvedSurfaceArea = curvedSurfaceArea;
    }

    @Override
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Curved Surface Area: " + Math.round(getCurvedSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Radius: " + getRadius());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("Shape's Slanted Height: " + Math.round(getSlantedHeight() * 100.0) / 100.0);
        PrintInterface.printSeparator();
    }

}
