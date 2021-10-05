package com.kimo.tictactoe;

import java.util.Scanner;

public class UserInterface {
    private Game game;

    private Scanner scan;

    public UserInterface(Scanner scan) {
        this.scan = scan;
    }

    public void start() {
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
            System.out.print("Player 1's name: ");
            String playerOneName = scan.nextLine();

            System.out.print("Player 1's symbol: ");
            char playerOneSymbol = scan.nextLine().charAt(0);

            System.out.print("Player 2's name: ");
            String playerTwoName = scan.nextLine();

            System.out.print("Player 2's symbol: ");
            char playerTwoSymbol = scan.nextLine().charAt(0);

            Player playerOne = new Player(playerOneName, playerOneSymbol);
            Player playerTwo = new Player(playerTwoName, playerTwoSymbol);

            this.game = new Game(playerOne, playerTwo);
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

    private void printCommandList() {
        System.out.println("1. Play a new game");
        System.out.println("2. Restart game");
        System.out.println("3. Print results of last game");
        System.out.println("4. Exit");
    }
}
