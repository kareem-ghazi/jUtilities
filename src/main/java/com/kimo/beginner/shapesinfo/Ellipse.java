package com.kimo.beginner.shapesinfo;

public class Ellipse extends Shape {
    private double axisA;
    private double axisB;

    public Ellipse(double axisA, double axisB) {
        setAxisA(axisA);
        setAxisB(axisB);
    }

    public double getAxisA() {
        return axisA;
    }

    public void setAxisA(double axisA) {
        this.axisA = axisA;
    }

    public double getAxisB() {
        return axisB;
    }

    public void setAxisB(double axisB) {
        this.axisB = axisB;
    }

    @Override
    public double getArea() {
        area = (Math.PI * getAxisA() * getAxisB());

        return area;
    }

    @Override
    public String getType() {
        type = "ELLIPSE";

        return type;
    }

    @Override
    public String getDefinition() {
        definition = "An ellipse is a plane curve surrounding two focal points, such that for all points on the curve, the sum of the two distances to the focal points is a constant.";

        return definition;
    }

    @Override
    public void dump() {
        System.out.println("-----------------------------------------");
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + Math.round(getArea() * 100.0) / 100.0);
        System.out.println("Shape's Axis A: " + getAxisA());
        System.out.println("Shape's Axis B: " + getAxisB());
        System.out.println("-----------------------------------------");
    }
    
}
