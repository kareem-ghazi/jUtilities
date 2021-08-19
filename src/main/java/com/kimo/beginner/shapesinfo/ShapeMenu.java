package com.kimo.beginner.shapesinfo;

import java.util.Scanner;

public class ShapeMenu {
    OptionMenu optionMenu = new OptionMenu();
    Scanner scan = new Scanner(System.in);

    public void get2DShapeMenu() {
        int userInput = 0;

        do {
            userInput = 0;
            print2DShapeCommandList();
            System.out.print("-: ");

            try {
                userInput = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();
            }

            switch (userInput) {
                case 1:
                    System.out.println("Works!");
                    break;
                case 7:
                    return;
                default:
                    printSeparator();
                    System.out.println("Invalid input.");
            }

        } while (true);

    }

    public void print2DShapeCommandList() {
        printSeparator();
        System.out.println("1. Get attributes of a Circle.");
        System.out.println("2. Get attributes of an Ellipse.");
        System.out.println("3. Get attributes of a Parallelogram.");
        System.out.println("4. Get attributes of a Rectangle.");
        System.out.println("5. Get attributes of a Square.");
        System.out.println("6. Get attributes of a Triangle.");
        System.out.println("7. Exit.");
    }

    public void get3DShapeMenu() {

    }

    public void printSeparator() {
        System.out.println("-------------------------------");
    }
}
