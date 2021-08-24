package com.kimo.intermediate.shapesinfo.threeDshapes;

import com.kimo.intermediate.shapesinfo.Shape;
import com.kimo.intermediate.shapesinfo.utils.PrintInterface;

public class Cube extends Shape {
    private double sideLength;
    private double lateralSurfaceArea;

    /**
     * Main constructor for the Cube class. Takes in side length of a cube as a parameter.
     * @param sideLength - Side length of a cube.
     */
    public Cube(double sideLength) {
        setSideLength(sideLength);
        setVolume(Math.pow(sideLength, 3));
        setSurfaceArea(6 * Math.pow(sideLength, 2));
        setLateralSurfaceArea(4 * Math.pow(sideLength, 2));
        setType("CUBE");
        setDefinition(
                "A cube is a three-dimensional solid object bounded by six square faces, facets or sides, with three meeting at each vertex.");
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
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
        System.out.println("Shape's Height: " + getSideLength());
        System.out.println("Shape's Width: " + getSideLength());
        PrintInterface.printSeparator();
    }
}
