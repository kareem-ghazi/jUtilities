package com.kimo.beginner.guessthenumber;

import com.kimo.beginner.guessthenumber.utils.PrintUtils;
import com.kimo.beginner.guessthenumber.utils.InputUtils;

public class Main {
    private static GuessTheNumber guessTheNumber = new GuessTheNumber();

    public static void main(String[] args) {
        System.out.println("GuessTheNumber - Guess a number between a specified range.");
        mainLoop();
        PrintUtils.printSeparator();
    }

    public static void mainLoop() {
        int userInput;

        do {
            printCommandList();
            
            System.out.print("-: ");
            userInput = InputUtils.getCaughtInput();

            PrintUtils.printSeparator();
            switch (userInput) {
                case 1:
                    guessTheNumber.play();
                    break;
                case 2:
                    guessTheNumber.printLastSession();
                    break;
                case 3:
                    System.out.print("Enter the minimum guess range: ");
                    int minimumGuessRange = InputUtils.getCaughtInput();

                    System.out.print("Enter the maximum guess range: ");
                    int maximumGuessRange = InputUtils.getCaughtInput();

                    guessTheNumber.setGuessRange(minimumGuessRange, maximumGuessRange);
                    PrintUtils.printSeparator();
                    System.out.println("Set the guess range successfully.");
                    break;
                case 4:
                    System.out.println("Exited program successfully.");
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        } while (true);
    }

    private static void printCommandList() {
        PrintUtils.printSeparator();
        System.out.println("1. Play a game.");
        System.out.println("2. Print out the results of last session.");
        System.out.println("3. Set the guess range.");
        System.out.println("4. Exit.");
    }
}
