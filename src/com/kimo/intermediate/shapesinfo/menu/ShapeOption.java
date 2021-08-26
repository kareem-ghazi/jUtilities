package com.kimo.intermediate.shapesinfo.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kimo.intermediate.shapesinfo.threeDshapes.Cone;
import com.kimo.intermediate.shapesinfo.threeDshapes.Cube;
import com.kimo.intermediate.shapesinfo.threeDshapes.Cuboid;
import com.kimo.intermediate.shapesinfo.threeDshapes.Cylinder;
import com.kimo.intermediate.shapesinfo.threeDshapes.Sphere;
import com.kimo.intermediate.shapesinfo.twoDshapes.Circle;
import com.kimo.intermediate.shapesinfo.twoDshapes.Ellipse;
import com.kimo.intermediate.shapesinfo.twoDshapes.Parallelogram;
import com.kimo.intermediate.shapesinfo.twoDshapes.Rectangle;
import com.kimo.intermediate.shapesinfo.twoDshapes.Square;
import com.kimo.intermediate.shapesinfo.twoDshapes.Triangle;

public class ShapeOption {
    private Scanner scan = new Scanner(System.in);

    /*
     * -----------------
     * 2D Shapes Section
     * -----------------
     * All 2D Shape options included in the 2D Shape menu.
     * -----------------
     */

    public void getCircleOption() {
        System.out.print("Enter a radius: ");
        int radius = getCaughtInput();

        Circle circle = new Circle(radius);
        circle.dump();
    }

    public void getEllipseOption() {
        System.out.print("Enter Axis A: ");
        int axisA = getCaughtInput();

        System.out.print("Enter Axis B: ");
        int axisB = getCaughtInput();

        Ellipse ellipse = new Ellipse(axisA, axisB);
        ellipse.dump();
    }

    public void getParallelogramOption() {
        System.out.print("Enter height: ");
        int height = getCaughtInput();

        System.out.print("Enter base: ");
        int base = getCaughtInput();

        Parallelogram parallelogram = new Parallelogram(height, base);
        parallelogram.dump();
    }

    public void getRectangleOption() {
        System.out.print("Enter length: ");
        int length = getCaughtInput();

        System.out.print("Enter width: ");
        int width = getCaughtInput();

        Rectangle rectangle = new Rectangle(length, width);
        rectangle.dump();
    }

    public void getSquareOption() {
        System.out.print("Enter side length: ");
        int sideLength = getCaughtInput();

        Square square = new Square(sideLength);
        square.dump();
    }

    public void getTriangleOption() {
        System.out.print("Enter height: ");
        int height = getCaughtInput();

        System.out.print("Enter base: ");
        int base = getCaughtInput();

        Triangle triangle = new Triangle(height, base);
        triangle.dump();
    }

    /*
     * -----------------
     * 3D Shapes Section
     * -----------------
     * All 3D Shape options included in the 3D Shape menu.
     * -----------------
     */

    public void getConeOption() {
        System.out.print("Enter radius: ");
        int radius = getCaughtInput();

        System.out.print("Enter height: ");
        int height = getCaughtInput();

        Cone cone = new Cone(radius, height);
        cone.dump();
    }

    public void getCubeOption() {
        System.out.print("Enter sidelength: ");
        int sideLength = getCaughtInput();

        Cube cube = new Cube(sideLength);
        cube.dump();
    }

    public void getCuboidOption() {
        System.out.print("Enter length: ");
        int length = getCaughtInput();

        System.out.print("Enter width: ");
        int width = getCaughtInput();

        System.out.print("Enter height: ");
        int height = getCaughtInput();

        Cuboid cuboid = new Cuboid(length, width, height);
        cuboid.dump();
    }

    public void getCylinderOption() {
        System.out.print("Enter radius: ");
        int radius = getCaughtInput();

        System.out.print("Enter height: ");
        int height = getCaughtInput();

        Cylinder cylinder = new Cylinder(radius, height);
        cylinder.dump();
    }

    public void getSphereOption() {
        System.out.print("Enter radius: ");
        int radius = getCaughtInput();

        Sphere sphere = new Sphere(radius);
        sphere.dump();
    }

    /*
     * -----------------
     * Helper methods Section
     * -----------------
     */

    /**
     * Method to catch scanner errors and loop the scanner until it gets valid input.
     * @return Returns valid input after it runs through the try-catch check.
     */
    public int getCaughtInput() {
        int input = 0;

        do {
            try {
                input = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Invalid input.");
                System.out.print("-: ");
            }
        } while (true);

        return input;
    } 
}
