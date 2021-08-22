package com.kimo.beginner.shapesinfo.menu;

import java.util.Scanner;

import com.kimo.beginner.shapesinfo.utils.PrintInterface;

public class ShapeMenu implements PrintInterface {
    private ShapeOption shapeOption = new ShapeOption();
    private Scanner scan = new Scanner(System.in);

    /**
     * The option menu for 2D Shapes.
     */
    public void get2DShapeMenu() {
        int userInput = 0;

        do {
            print2DShapeCommandList();
            System.out.print("-: ");
            userInput = 0;

            try {
                userInput = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();
            }

            switch (userInput) {
                case 1:
                    shapeOption.getCircleOption();
                    break;
                case 2:
                    shapeOption.getEllipseOption();
                    break;
                case 3:
                    shapeOption.getParallelogramOption();
                    break;
                case 4:
                    shapeOption.getRectangleOption();
                    break;
                case 5:
                    shapeOption.getSquareOption();
                    break;
                case 6:
                    shapeOption.getTriangleOption();
                    break;
                case 7:
                    return;
                default:
                    PrintInterface.printSeparator();
                    System.out.println("Invalid input.");
            }

        } while (true);

    }

    public void print2DShapeCommandList() {
        System.out.println(">>> 2D Shapes <<<");
        PrintInterface.printSeparator();
        System.out.println("1. Get attributes of a Circle.");
        System.out.println("2. Get attributes of an Ellipse.");
        System.out.println("3. Get attributes of a Parallelogram.");
        System.out.println("4. Get attributes of a Rectangle.");
        System.out.println("5. Get attributes of a Square.");
        System.out.println("6. Get attributes of a Triangle.");
        System.out.println("7. Exit.");
    }

    /**
     * The option menu for 3D Shapes.
     */
    public void get3DShapeMenu() {
        int userInput = 0;

        do {
            print3DShapeCommandList();
            System.out.print("-: ");
            userInput = 0;

            try {
                userInput = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();
            }

            switch (userInput) {
                case 1:
                    shapeOption.getConeOption();
                    break;
                case 2:
                    shapeOption.getCubeOption();
                    break;
                case 3:
                    shapeOption.getCuboidOption();
                    break;
                case 4:
                    shapeOption.getCylinderOption();
                    break;
                case 5:
                    shapeOption.getSphereOption();
                    break;
                case 6:
                    return;
                default:
                    PrintInterface.printSeparator();
                    System.out.println("Invalid input.");
            }

        } while (true);
    }

    public void print3DShapeCommandList() {
        System.out.println(">>> 3D Shapes <<<");
        PrintInterface.printSeparator();
        System.out.println("1. Get attributes of a Cone.");
        System.out.println("2. Get attributes of an Cube.");
        System.out.println("3. Get attributes of a Cuboid.");
        System.out.println("4. Get attributes of a Cylinder.");
        System.out.println("5. Get attributes of a Sphere.");
        System.out.println("6. Exit.");
    }

}
