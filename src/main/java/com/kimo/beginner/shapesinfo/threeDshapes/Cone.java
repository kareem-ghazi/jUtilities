package com.kimo.beginner.shapesinfo.threeDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Cone extends Shape {
    private double height;
    private double radius;

    private double slantedHeight;
    private double curvedSurfaceArea;

    public Cone(double radius, double height) {
        setHeight(height);
        setRadius(radius);
        setSlantedHeight(Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
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
        curvedSurfaceArea = (Math.PI * getRadius() * getSlantedHeight());

        return curvedSurfaceArea;
    }

    @Override
    public double getVolume() {
        volume = (Math.PI * Math.pow(getRadius(), 2) * getHeight()) / 3;

        return volume;
    }

    @Override
    public double getSurfaceArea() {
        surfaceArea = (Math.PI * getRadius() * (getSlantedHeight() + getRadius()));

        return surfaceArea;
    }

    @Override
    public String getDefinition() {
        definition = "A cone is a three-dimensional geometric shape that tapers smoothly from a flat base to a point called the apex or vertex.";

        return definition;
    }

    @Override
    public String getType() {
        type = "CONE";

        return type;
    }

    @Override
    public void dump() {
        PrintUtils.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Curved Surface Area: " + Math.round(getCurvedSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Radius: " + getRadius());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("Shape's Slanted Height: " + Math.round(getSlantedHeight() * 100.0) / 100.0);
        PrintUtils.printSeparator();
    }

}
