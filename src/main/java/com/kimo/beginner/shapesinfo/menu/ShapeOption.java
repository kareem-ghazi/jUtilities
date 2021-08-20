package com.kimo.beginner.shapesinfo.menu;

import java.util.Scanner;

import com.kimo.beginner.shapesinfo.threeDshapes.Cone;
import com.kimo.beginner.shapesinfo.threeDshapes.Cube;
import com.kimo.beginner.shapesinfo.threeDshapes.Cuboid;
import com.kimo.beginner.shapesinfo.threeDshapes.Cylinder;
import com.kimo.beginner.shapesinfo.threeDshapes.Sphere;
import com.kimo.beginner.shapesinfo.twoDshapes.Circle;
import com.kimo.beginner.shapesinfo.twoDshapes.Ellipse;
import com.kimo.beginner.shapesinfo.twoDshapes.Parallelogram;
import com.kimo.beginner.shapesinfo.twoDshapes.Rectangle;
import com.kimo.beginner.shapesinfo.twoDshapes.Square;
import com.kimo.beginner.shapesinfo.twoDshapes.Triangle;

public class ShapeOption {
    private Scanner scan = new Scanner(System.in);
    
    // 2D SHAPES SECTION
    // 2D SHAPES SECTION
    // 2D SHAPES SECTION

    public void getCircleOption() {
        System.out.print("Enter a radius: ");
        int radius = scan.nextInt();

        Circle circle = new Circle(radius);
        circle.dump();
    }

    public void getEllipseOption() {
        System.out.print("Enter Axis A: ");
        int axisA = scan.nextInt();

        System.out.print("Enter Axis B: ");
        int axisB = scan.nextInt();

        Ellipse ellipse = new Ellipse(axisA, axisB);
        ellipse.dump();
    }

    public void getParallelogramOption() {
        System.out.print("Enter height: ");
        int height = scan.nextInt();

        System.out.print("Enter base: ");
        int base = scan.nextInt();

        Parallelogram parallelogram = new Parallelogram(height, base);
        parallelogram.dump();
    }

    public void getRectangleOption() {
        System.out.print("Enter length: ");
        int length = scan.nextInt();

        System.out.print("Enter width: ");
        int width = scan.nextInt();

        Rectangle rectangle = new Rectangle(length, width);
        rectangle.dump();
    }

    public void getSquareOption() {
        System.out.print("Enter side length: ");
        int sideLength = scan.nextInt();

        Square square = new Square(sideLength);
        square.dump();
    }

    public void getTriangleOption() {
        System.out.print("Enter height: ");
        int height = scan.nextInt();

        System.out.print("Enter base: ");
        int base = scan.nextInt();

        Triangle triangle = new Triangle(height, base);
        triangle.dump();
    }

    // 3D SHAPES SECTION
    // 3D SHAPES SECTION
    // 3D SHAPES SECTION

    public void getConeOption() {
        System.out.print("Enter radius: ");
        int radius = scan.nextInt();

        System.out.print("Enter height: ");
        int height = scan.nextInt();

        Cone cone = new Cone(radius, height);
        cone.dump();
    }

    public void getCubeOption() {
        System.out.print("Enter sidelength: ");
        int sideLength = scan.nextInt();

        Cube cube = new Cube(sideLength);
        cube.dump();
    }

    public void getCuboidOption() {
        System.out.print("Enter length: ");
        int length = scan.nextInt();

        System.out.print("Enter width: ");
        int width = scan.nextInt();

        System.out.print("Enter height: ");
        int height = scan.nextInt();

        Cuboid cuboid = new Cuboid(length, width, height);
        cuboid.dump();
    }

    public void getCylinderOption() {
        System.out.print("Enter radius: ");
        int radius = scan.nextInt();

        System.out.print("Enter height: ");
        int height = scan.nextInt();

        Cylinder cylinder = new Cylinder(radius, height);
        cylinder.dump();
    }

    public void getSphereOption() {
        System.out.print("Enter radius: ");
        int radius = scan.nextInt();

        Sphere sphere = new Sphere(radius);
        sphere.dump();
    }
}
