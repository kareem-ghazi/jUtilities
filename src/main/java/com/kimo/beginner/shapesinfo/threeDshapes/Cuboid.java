package com.kimo.beginner.shapesinfo.threeDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public class Cuboid extends Shape {
    private double length;
    private double width;
    private double height;

    private double lateralSurfaceArea;

    /**
     * Main constructor for the Cuboid class. Takes in length, width, and height of a cuboid as parameters.
     * @param length - Length of a cuboid.
     * @param width - Width of a cuboid.
     * @param height - Height of a cuboid.
     */
    public Cuboid(double length, double width, double height) {
        setHeight(height);
        setWidth(width);
        setLength(length);
        setVolume(height * width * length);
        setSurfaceArea(2 * ((length * width) + (width * height) + (length * height)));
        setLateralSurfaceArea(2 * height * (width + length));
        setType("CUBOID");
        setDefinition("A cuboid is a solid shape with six rectangular surfaces or four rectangular and two square surfaces.");
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
        return lateralSurfaceArea;
    }

    public void setLateralSurfaceArea(double lateralSurfaceArea) {
        this.lateralSurfaceArea = lateralSurfaceArea;
    }

    @Override
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Lateral Surface Area: " + Math.round(getLateralSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Length: " + getLength());
        System.out.println("Shape's Width: " + getWidth());
        System.out.println("Shape's Height: " + getHeight());
        PrintInterface.printSeparator();
    }

}
