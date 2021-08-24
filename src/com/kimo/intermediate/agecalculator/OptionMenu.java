package com.kimo.intermediate.agecalculator;

import java.util.Scanner;

public class OptionMenu {
    private Scanner scan = new Scanner(System.in);
    private Application app = new Application();
    private User user;

    // Creates a new user.
    public void createUser() {
        int birthYear = 0;
        int birthMonth = 0;
        int birthDay = 0;

        String username;
        String nationality;

        System.out.print("Enter your name: ");
        username = scan.nextLine();

        System.out.print("Enter your nationality: ");
        nationality = scan.nextLine();

        System.out.print("Enter your birth year: ");
        birthYear = catchInputError(birthYear);

        System.out.print("Enter your birth month: ");
        birthMonth = catchInputError(birthMonth);

        System.out.print("Enter your birth day: ");
        birthDay = catchInputError(birthDay);

        user = new User(username, nationality, birthYear, birthMonth, birthDay);
    }

    // Prints out basic information about the user. (username, nationality, birthdate)
    public void printUserInformation() {
        if (this.user != null) {
            System.out.println("Name: " + user.getUsername());
            System.out.println("Nationality: " + user.getNationality());
            System.out.println("Birthdate: " + user.getBirthdate().getDayOfMonth() + "/"
                    + user.getBirthdate().getMonthValue() + "/" + user.getBirthdate().getYear());
            System.out.println("-------------------------------------");
            System.out.println(app.getAge(user.getBirthdate()));
            System.out.println(app.getNextBirthday(user.getBirthdate()));
        } else {
            System.err.println("You have not set your information yet.");
        }
    }

    // Prints out the age on different planets.
    public void printAgeOnPlanets() {
        if (this.user != null) {
            System.out.println("Your age in years on different planets:");
            System.out.println();
            System.out.println("Mercury - " + app.getAgeOnPlanet(user.getBirthdate(), "mercury") + " year(s)");
            System.out.println("Venus - " + app.getAgeOnPlanet(user.getBirthdate(), "venus") + " year(s)");
            System.out.println("Earth - " + app.getAgeOnPlanet(user.getBirthdate(), "earth") + " year(s)");
            System.out.println("Mars - " + app.getAgeOnPlanet(user.getBirthdate(), "mars") + " year(s)");
            System.out.println("Jupiter - " + app.getAgeOnPlanet(user.getBirthdate(), "jupiter") + " year(s)");
            System.out.println("Saturn - " + app.getAgeOnPlanet(user.getBirthdate(), "saturn") + " year(s)");
            System.out.println("Uranus - " + app.getAgeOnPlanet(user.getBirthdate(), "uranus") + " year(s)");
            System.out.println("Neptune - " + app.getAgeOnPlanet(user.getBirthdate(), "neptune") + " year(s)");
            System.out.println("Pluto - " + app.getAgeOnPlanet(user.getBirthdate(), "pluto") + " year(s)");
        } else {
            System.err.println("You have not set your information yet.");
        }
    }

    // Prints out the age in different time intervals. (seconds, hours, days)
    public void printAgeInIntervals() {
        if (this.user != null) {
            System.out.println("Your age in seconds is: " + app.getAgeInSeconds(user.getBirthdate()));
            System.out.println("Your age in hours is: " + app.getAgeInHours(user.getBirthdate()));
            System.out.println("Your age in days is: " + app.getAgeInDays(user.getBirthdate()));
        } else {
            System.err.println("You have not set your information yet.");
        }
    }

    // Prints out the message for exiting the program.
    public void printExitMessage() {
        System.out.println("Exited program successfully.");
        System.out.println("-------------------------------------");
    }

    // Try-catch statements for invalid input.
    private int catchInputError(int input) {
        do {
            try {
                input = scan.nextInt();
                break;
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Invalid input.");
                System.out.print("-: ");
            }
        } while (true);
        scan.nextLine();

        return input;
    }

}