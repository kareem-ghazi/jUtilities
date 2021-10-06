package com.kimo.tictactoe;

import java.util.Scanner;

public class UserInterface {
    private Game game;

    private Scanner scan;

    public UserInterface(Scanner scan) {
        this.scan = scan;
    }

    public void start() {
        System.out.println("TicTacToe - Classical game but with some music.");

        while (true) {
            printCommandList();

            System.out.print("-: ");
            int input;

            try {
                input = Integer.valueOf(scan.nextLine());
            } catch (NumberFormatException e) {
                input = 0;
            }

            if (input == 4) {
                break;
            }

            processInput(input);
        }
    }

    private void processInput(int input) {
        if (input == 1) {
            createGameInterface();
            this.game.start();
        } else if (input == 2) {
            if (this.game != null) {
                this.game.start();
            }
        } else if (input == 3) {
            if (this.game != null) {
                System.out.println(this.game);
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

    private void createGameInterface() {
        System.out.print("Player 1's name: ");
        String playerOneName = scan.nextLine();

        System.out.print("Player 1's symbol: ");
        char playerOneSymbol = scan.nextLine().charAt(0);

        System.out.print("Player 2's name: ");
        String playerTwoName = scan.nextLine();

        System.out.print("Player 2's symbol: ");
        char playerTwoSymbol = scan.nextLine().charAt(0);

        System.out.print("Music (true/false): ");
        boolean musicEnabled = Boolean.parseBoolean(scan.nextLine());

        Player playerOne = new Player(playerOneName, playerOneSymbol);
        Player playerTwo = new Player(playerTwoName, playerTwoSymbol);

        if (musicEnabled) {
            this.game = new Game(playerOne, playerTwo, new Music());
        } else {
            this.game = new Game(playerOne, playerTwo);
        }
    }

    private void printCommandList() {
        System.out.println("1. Play a new game");
        System.out.println("2. Restart game");
        System.out.println("3. Print results of last game");
        System.out.println("4. Exit");
    }
}
