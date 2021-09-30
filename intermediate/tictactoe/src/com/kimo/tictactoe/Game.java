package com.kimo.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Scanner scan;

    private char[][] gameBoard;

    private Player firstPlayer;

    private Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.scan = new Scanner(System.in);

        this.gameBoard = new char[][] { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
    }

    public void printBoard() {
        System.out.println("  A   B   C");

        int rowIndex = 0;
        int rowCount = 0;

        for (char[] row : gameBoard) {
            if (rowIndex % 2 == 0 || rowIndex == 0) {
                rowCount++;

                System.out.print(rowCount);
                System.out.print(" ");
            } else {
                System.out.print("  ");
            }

            for (char character : row) {
                System.out.print(character + " ");
            }

            rowIndex++;
            System.out.println();
        }
    }

    public void resetBoard() {
        this.gameBoard = new char[][] { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
    }

    public void place(Player player, String position) {
        while (firstPlayer.getPositions().contains(position) || secondPlayer.getPositions().contains(position)) {
            System.out.print("Taken position! Try again: ");
            position = scan.nextLine();
        }

        switch (Character.getNumericValue(position.charAt(0))) {
            case 1:
                switch (position.charAt(1)) {
                    case 'A':
                        gameBoard[0][0] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    case 'B':
                        gameBoard[0][2] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    case 'C':
                        gameBoard[0][4] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    default:
                        break;
                }

                break;
            case 2:
                switch (position.charAt(1)) {
                    case 'A':
                        gameBoard[2][0] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    case 'B':
                        gameBoard[2][2] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    case 'C':
                        gameBoard[2][4] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    default:
                        break;
                }

                break;
            case 3:
                switch (position.charAt(1)) {
                    case 'A':
                        gameBoard[4][0] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    case 'B':
                        gameBoard[4][2] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    case 'C':
                        gameBoard[4][4] = player.getSymbol();
                        player.getPositions().add(position);
                        break;
                    default:
                        break;
                }

                break;
            default:
                break;
        }
    }

    public String getWinner() {
        List<String> topRow = Arrays.asList("1A", "2A", "3A");
        List<String> middleRow = Arrays.asList("1B", "2B", "3B");
        List<String> bottomRow = Arrays.asList("1C", "2C", "3C");

        List<String> leftColumn = Arrays.asList("1A", "1B", "1C");
        List<String> middleColumn = Arrays.asList("2A", "2B", "2C");
        List<String> rightColumn = Arrays.asList("1C", "2C", "3C");

        List<String> firstCross = Arrays.asList("1A", "2B", "3C");
        List<String> secondCross = Arrays.asList("1C", "2B", "3A");

        List<List<String>> winningConditions = new ArrayList<>();

        Collections.addAll(winningConditions, topRow, middleRow, bottomRow, leftColumn, middleColumn, rightColumn,
                firstCross, secondCross);

        for (List<String> list : winningConditions) {
            if (firstPlayer.getPositions().containsAll(list)) {
                return "Congratulations " + firstPlayer.getName() + ", you won!";
            } else if (secondPlayer.getPositions().containsAll(list)) {
                return "Congratulations " + secondPlayer.getName() + ", you won!";
            }
        }

        if (firstPlayer.getPositions().size() + secondPlayer.getPositions().size() == 9) {
            return "TIE!";
        }

        return "";
    }

    public void start(boolean restart) {
        Player playerTurn = firstPlayer;

        String position;
        String roundResult;

        while (true) {
            printBoard();
            
            System.out.print("Enter a position (" + playerTurn.getSymbol() + "): ");
            position = scan.nextLine();
            
            if (position.equals("")) {
                break;
            }

            place(playerTurn, position);

            if (playerTurn.equals(firstPlayer)) {
                playerTurn = secondPlayer;
            } else if (playerTurn.equals(secondPlayer)) {
                playerTurn = firstPlayer;
            }

            roundResult = getWinner();

            if (roundResult.length() > 0) {
                printBoard();
                System.out.println(roundResult);
                break;
            }
        }

        if (restart) {
            System.out.print("Restart (Y/N): ");
            String response = scan.nextLine();

            if (response.toUpperCase().equals("Y")) {
                this.start();
            }
        }
    }

    public void start() {
        start(false);
    }
}
