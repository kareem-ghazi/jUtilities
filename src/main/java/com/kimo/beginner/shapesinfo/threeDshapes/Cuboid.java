package com.kimo.beginner.shapesinfo.threeDshapes;

import com.kimo.beginner.shapesinfo.Shape;

public class Cuboid extends Shape {
    private double length;
    private double width;
    private double height;

    private double lateralSurfaceArea;

    public Cuboid(double length, double width, double height) {
        setHeight(height);
        setWidth(width);
        setLength(length);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLateralSurfaceArea() {
        lateralSurfaceArea = 2 * getHeight() * (getWidth() + getLength());

        return lateralSurfaceArea;
    }

    @Override
    public double getVolume() {
        volume = getHeight() * getWidth() * getLength();

        return volume;
    }

    @Override
    public double getSurfaceArea() {
        surfaceArea = 2 * ((getLength() * getWidth()) + (getWidth() * getHeight()) + (getLength() * getHeight()));

        return surfaceArea;
    }

    @Override
    public String getDefinition() {
        definition = "A cuboid is a solid shape with six rectangular surfaces or four rectangular and two square surfaces.";

        return definition;
    }

    @Override
    public String getType() {
        type = "CUBOID";

        return type;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Lateral Surface Area: " + Math.round(getLateralSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Length: " + getLength());
        System.out.println("Shape's Width: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        System.out.println("-----------------------------------------");
    }

}
