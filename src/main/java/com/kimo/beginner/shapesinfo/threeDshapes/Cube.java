package com.kimo.beginner.shapesinfo.threeDshapes;

import com.kimo.beginner.shapesinfo.Shape;
import com.kimo.beginner.shapesinfo.utils.PrintUtils;

public class Cube extends Shape {
    private double sideLength;
    private double lateralSurfaceArea;

    public Cube(double sideLength) {
        setSideLength(sideLength);
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getLateralSurfaceArea() {
        lateralSurfaceArea = (4 * Math.pow(getSideLength(), 2));

        return lateralSurfaceArea;
    }

    @Override
    public double getVolume() {
        volume = Math.pow(getSideLength(), 3);

        return volume;
    }

    @Override
    public double getSurfaceArea() {
        surfaceArea = (6 * Math.pow(getSideLength(), 2));

        return surfaceArea;
    }

    @Override
    public String getDefinition() {
        definition = "A cube is a three-dimensional solid object bounded by six square faces, facets or sides, with three meeting at each vertex.";

        return definition;
    }

    @Override
    public String getType() {
        type = "CUBE";

        return type;
    }

    @Override
    public void dump() {
        PrintUtils.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Volume: " + Math.round(getVolume() * 100.0) / 100.0);
        System.out.println("Shape's Surface Area: " + Math.round(getSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Lateral Surface Area: " + Math.round(getLateralSurfaceArea() * 100.0) / 100.0);
        System.out.println("Shape's Height: " + getSideLength());
        System.out.println("Shape's Width: " + getSideLength());
        PrintUtils.printSeparator();
    }
}
