package com.kimo.beginner.shapesinfo;

public class Sphere extends Shape {
    private double radius;
    
    public Sphere(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        volume = (Math.PI * Math.pow(getRadius(), 3) * 4) / 3;

        return volume;
    }

    @Override
    public double getSurfaceArea() {
        surfaceArea = (4 * Math.PI * Math.pow(getRadius(), 2));

        return surfaceArea;
    }

    @Override
    public String getType() {
        type = "SPHERE";

        return type;
    }

    @Override
    public String getDefinition() {
        definition = "A sphere is a geometrical object in three-dimensional space that is the surface of a ball.";

        return definition;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Radius: " + getRadius());
        System.out.println("-----------------------------------------");
    }
}
