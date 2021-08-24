package com.kimo.advanced.calculator.monoperational;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--------------------------");
        System.out.print("-: ");
        String userInput = scan.nextLine();

        String[] parsedInput = userInput.split(" ");
        double endResult = 0;
        double[] numbers = new double[10];
        char operand = ' ';

        for (int i = 0, j = 0; i < parsedInput.length; i++, j++) {
            if (isNumeric(parsedInput[i])) {
                numbers[j] = Double.parseDouble(parsedInput[i]);
                if (j == 0) {
                    endResult = numbers[0];
                }

                if (operand == '*') {
                    endResult *= numbers[j];
                } else if (operand == '/') {
                    endResult /= numbers[j];
                } else if (operand == '+') {
                    endResult += numbers[j];
                } else if (operand == '-') {
                    endResult -= numbers[j];
                }
            } else {
                if (parsedInput[i].equals("*")) {
                    operand = parsedInput[i].charAt(0);
                } else if (parsedInput[i].equals("/")) {
                    operand = parsedInput[i].charAt(0);
                } else if (parsedInput[i].equals("+")) {
                    operand = parsedInput[i].charAt(0);
                } else if (parsedInput[i].equals("-")) {
                    operand = parsedInput[i].charAt(0);
                }
                
                j--;
            }
        }

        System.out.println(endResult);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}