package com.kimo.agecalculator;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    private AgeCalculator ageCalculator;

    private User user;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            printCommandList();
            System.out.print("-: ");

            int choice = 0;

            try {
                choice = Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                continue;
            }

            if (choice == 5) {
                System.out.println("Exited program successfully.");
                break;
            }

            processChoice(choice);
        }
    }

    private void processChoice(int choice) {
        switch (choice) {
        case 1:
            createUser();
            break;
        case 2:
            printUserInformation();
            break;
        case 3:
            printAgeOnPlanets();
            break;
        case 4:
            printAgeInIntervals();
            break;
        default:
            System.out.println("Invalid choice.");
            break;
        }
    }

    private void printAgeInIntervals() {
        if (this.user == null) {
            System.err.println("You have not set your information yet.");
            return;
        }

        System.out.println("Your age in seconds is: " + ageCalculator.getAgeInSeconds());
        System.out.println("Your age in hours is: " + ageCalculator.getAgeInHours());
        System.out.println("Your age in days is: " + ageCalculator.getAgeInDays());
    }

    private void printAgeOnPlanets() {
        if (this.user == null) {
            System.err.println("You have not set your information yet.");
            return;
        }

        System.out.println("Your age in years on different planets:");
        System.out.println();
        System.out.println("Mercury - " + ageCalculator.getAgeOnPlanet("mercury") + " year(s)");
        System.out.println("Venus - " + ageCalculator.getAgeOnPlanet("venus") + " year(s)");
        System.out.println("Earth - " + ageCalculator.getAgeOnPlanet("earth") + " year(s)");
        System.out.println("Mars - " + ageCalculator.getAgeOnPlanet("mars") + " year(s)");
        System.out.println("Jupiter - " + ageCalculator.getAgeOnPlanet("jupiter") + " year(s)");
        System.out.println("Saturn - " + ageCalculator.getAgeOnPlanet("saturn") + " year(s)");
        System.out.println("Uranus - " + ageCalculator.getAgeOnPlanet("uranus") + " year(s)");
        System.out.println("Neptune - " + ageCalculator.getAgeOnPlanet("neptune") + " year(s)");
        System.out.println("Pluto - " + ageCalculator.getAgeOnPlanet("pluto") + " year(s)");
    }

    private void printUserInformation() {
        if (this.user == null) {
            System.err.println("You have not set your information yet.");
            return;
        }

        System.out.println("Name: " + user.getUsername());
        System.out.println("Nationality: " + user.getNationality());
        System.out.println("Birthdate: " + user.getBirthdate().getDayOfMonth() + "/"
                + user.getBirthdate().getMonthValue() + "/" + user.getBirthdate().getYear());
        System.out.println("-------------------------------------");
        System.out.println(
                "You are " + ageCalculator.getAge().getYears() + " year(s), " + ageCalculator.getAge().getMonths()
                        + " month(s), " + ageCalculator.getAge().getDays() + " day(s) old.");
        System.out.println(ageCalculator.getNextBirthday().getMonths() + " month(s), "
                + ageCalculator.getNextBirthday().getDays() + " day(s) remain until your next birthday.");
    }

    private void createUser() {
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        System.out.print("Enter your nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Enter your birth year: ");
        int birthYear = getValidIntegerInput();

        System.out.print("Enter your birth month: ");
        int birthMonth = getValidIntegerInput();

        System.out.print("Enter your birth day: ");
        int birthDay = getValidIntegerInput();

        this.user = new User(username, nationality, birthYear, birthMonth, birthDay);
        this.ageCalculator = new AgeCalculator(user);
    }

    public static void printCommandList() {
        System.out.println("1. Setup your birthdate.");
        System.out.println("2. Print out a summary about your birthdate.");
        System.out.println("3. Print out your age on different planets.");
        System.out.println("4. Print out your age in different times.");
        System.out.println("5. Exit.");

    }

    private int getValidIntegerInput() {
        int input = 0;

        do {
            try {
                input = Integer.valueOf(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid input.");
                System.out.print("-: ");
            }
        } while (true);

        return input;
    }
}
