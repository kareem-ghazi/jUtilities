package com.kimo.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        char[][] board = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

        Scanner scan = new Scanner(System.in);
        char turn = ' ';

        while (true) {
            printGameBoard(board);

            if (turn == 'x') {
                turn = 'o';
            } else if (turn == 'o') {
                turn = 'x';
            } else {
                turn = 'x';
            }

            System.out.print("Enter a position (" + turn + "): ");
            String position = scan.nextLine();

            if (position.equals("")) {
                break;
            }

            placePiece(board, position, turn);
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
        switch (position.charAt(0)) {
            case 'A':
                switch (Character.getNumericValue(position.charAt(1))) {
                    case 1:
                        board[0][0] = playerSymbol;
                        break;
                    case 2:
                        board[0][2] = playerSymbol;
                        break;
                    case 3:
                        board[0][4] = playerSymbol;
                        break;
                    default:
                        break;
                }

                break;
            case 'B':
                switch (Character.getNumericValue(position.charAt(1))) {
                    case 1:
                        board[2][0] = playerSymbol;
                        break;
                    case 2:
                        board[2][2] = playerSymbol;
                        break;
                    case 3:
                        board[2][4] = playerSymbol;
                        break;
                    default:
                        break;
                }

                break;
            case 'C':
                switch (Character.getNumericValue(position.charAt(1))) {
                    case 1:
                        board[4][0] = playerSymbol;
                        break;
                    case 2:
                        board[4][2] = playerSymbol;
                        break;
                    case 3:
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
}
