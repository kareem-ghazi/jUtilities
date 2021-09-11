package com.kimo.shapesinfo;

import com.kimo.shapesinfo.utils.PrintInterface;

public abstract class Shape implements PrintInterface {
    private double area;
    private double perimeter;
    private double volume;
    private double surfaceArea;

    private String definition;
    private String type;

    /**
     * Sets the area for a 2D shape
     * @param area - Area of a shape 
     */
    protected void setArea(double area) {
        this.area = area;
    }

    /**
     * Sets the perimeter for a 2D shape
     * @param perimeter - Perimeter of a shape
     */
    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    
    /**
     * Sets the volume for a 3D shape
     * @param volume - Volume of a shape
     */
    protected void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Sets the surface area for a 3D shape
     * @param surfaceArea - Surface area of a shape
     */
    protected void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    /**
     * Sets the definition for any shape
     * @param definition - Definition of a shape
     */
    protected void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * Sets the type ("CIRCLE", "SQUARE", "TRIANGLE") for any shape
     * @param type - Type of a shape
     */
    protected void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public double getVolume() {
        return volume;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public String getDefinition() {
        return definition;
    }

    public String getType() {
        return type;
    }

    /**
     * Used to print an information dump about a shape
     */
    public abstract void dump();
}
