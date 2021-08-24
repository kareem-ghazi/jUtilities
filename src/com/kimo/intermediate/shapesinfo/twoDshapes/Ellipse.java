package com.kimo.intermediate.shapesinfo.twoDshapes;

import com.kimo.intermediate.shapesinfo.Shape;
import com.kimo.intermediate.shapesinfo.utils.PrintInterface;

public class Ellipse extends Shape {
    private double axisA;
    private double axisB;

    /**
     * Main constructor for the Ellipse class. Takes in axis A and axis B of an ellipse as parameters.
     * @param axisA - Axis A of an ellipse.
     * @param axisB - Axis B of an ellipse.
     */
    public Ellipse(double axisA, double axisB) {
        setAxisA(axisA);
        setAxisB(axisB);
        setArea((Math.PI * axisA * axisB));
        setType("ELLIPSE");
        setDefinition(
                "An ellipse is a plane curve surrounding two focal points, such that for all points on the curve, the sum of the two distances to the focal points is a constant.");
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
    public void dump() {
        PrintInterface.printSeparator();
        System.out.println("Shape's Type: " + getType());
        System.out.println("Shape's Definition: " + getDefinition());
        System.out.println("Shape's Area: " + Math.round(getArea() * 100.0) / 100.0);
        System.out.println("Shape's Axis A: " + getAxisA());
        System.out.println("Shape's Axis B: " + getAxisB());
        PrintInterface.printSeparator();
    }

}
