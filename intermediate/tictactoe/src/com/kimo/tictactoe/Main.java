package com.kimo.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<String> playerOnePositions = new ArrayList<>();
    static ArrayList<String> playerTwoPositions = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        char[][] board = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

        Scanner scan = new Scanner(System.in);

        char playerOne = 'x';
        char playerTwo = 'o';

        char turn = playerOne;

        while (true) {
            printGameBoard(board);

            System.out.print("Enter a position (" + turn + "): ");
            String position = scan.nextLine();

            if (position.equals("")) {
                break;
            }

            while (playerOnePositions.contains(position) || playerTwoPositions.contains(position)) {
                System.out.print("Taken position! Try again: ");
                position = scan.nextLine();
            }

            placePiece(board, position, turn);

            if (turn == playerOne) {
                turn = playerTwo;
                playerOnePositions.add(position);
            } else if (turn == playerTwo) {
                turn = playerOne;
                playerTwoPositions.add(position);
            }

            String roundResult = checkWinner();

            if (roundResult.length() > 0) {
                printGameBoard(board);
                System.out.println(roundResult);
                break;
            }
        }

        scan.close();
    }

    public static void printGameBoard(char[][] board) {
        System.out.println("  A   B   C");

        int rowIndex = 0;
        int rowCount = 0;

        for (char[] row : board) {
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

    public static void placePiece(char[][] board, String position, char playerSymbol) {
        switch (Character.getNumericValue(position.charAt(0))) {
            case 1:
                switch (position.charAt(1)) {
                    case 'A':
                        board[0][0] = playerSymbol;
                        break;
                    case 'B':
                        board[0][2] = playerSymbol;
                        break;
                    case 'C':
                        board[0][4] = playerSymbol;
                        break;
                    default:
                        break;
                }

                break;
            case 2:
                switch (position.charAt(1)) {
                    case 'A':
                        board[2][0] = playerSymbol;
                        break;
                    case 'B':
                        board[2][2] = playerSymbol;
                        break;
                    case 'C':
                        board[2][4] = playerSymbol;
                        break;
                    default:
                        break;
                }

                break;
            case 3:
                switch (position.charAt(1)) {
                    case 'A':
                        board[4][0] = playerSymbol;
                        break;
                    case 'B':
                        board[4][2] = playerSymbol;
                        break;
                    case 'C':
                        board[4][4] = playerSymbol;
                        break;
                    default:
                        break;
                }

                break;
            default:
                break;
        }
    }

    public static String checkWinner() {
        List topRow = Arrays.asList("1A", "2A", "3A");
        List middleRow = Arrays.asList("1B", "2B", "3B");
        List bottomRow = Arrays.asList("1C", "2C", "3C");

        List leftColumn = Arrays.asList("1A", "1B", "1C");
        List middleColumn = Arrays.asList("2A", "2B", "2C");
        List rightColumn = Arrays.asList("1C", "2C", "3C");

        List firstCross = Arrays.asList("1A", "2B", "3C");
        List secondCross = Arrays.asList("1C", "2B", "3A");

        List<List> winningConditions = new ArrayList<>();
        Collections.addAll(winningConditions, topRow, middleRow, bottomRow, leftColumn, middleColumn, rightColumn,
                firstCross, secondCross);

        for (List list : winningConditions) {
            if (playerOnePositions.containsAll(list)) {
                return "Congratulations player one, you won!";
            } else if (playerTwoPositions.containsAll(list)) {
                return "Congratulations player two, you won!";
            }
        }

        if (playerOnePositions.size() + playerTwoPositions.size() == 9) {
            return "TIE!";
        }

        return "";
    }
}
