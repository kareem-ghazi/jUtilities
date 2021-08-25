package com.kimo.advanced.calculator.singleoperational;

import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.MathUtils;
import com.kimo.advanced.calculator.singleoperational.utils.PrintUtils;

public class Calculator {
    static Scanner scan = new Scanner(System.in);

    public void calculationMode() {
        String userInput = "";
        String[] parsedInput;

        while (true) {
            PrintUtils.printSeparator();

            System.out.print("-: ");
            userInput = scan.nextLine();
            parsedInput = userInput.split(" ");

            if (userInput.equals("!q")) {
                break;
            }

            System.out.println(calculateInput(parsedInput));
        }

    }

    public void dump() {

    }

    private double calculateInput(String[] parsedInput) {
        double result = 0;
        double[] numbers = new double[25];
        char operand = ' ';

        boolean isAddition;
        boolean isSubtraction;
        boolean isMultiplication;
        boolean isDivision;
        boolean isPower;

        for (int i = 0, j = 0; i < parsedInput.length; i++, j++) {
            isAddition = parsedInput[i].equals("+");
            isSubtraction = parsedInput[i].equals("-");
            isMultiplication = parsedInput[i].equals("*");
            isDivision = parsedInput[i].equals("/");
            isPower = parsedInput[i].equals("^");

            if (MathUtils.isNumeric(parsedInput[i])) {
                numbers[j] = Double.parseDouble(parsedInput[i]);
                if (j == 0) {
                    result = numbers[0];
                }

                if (operand == '*') {
                    result *= numbers[j];
                } else if (operand == '/') {
                    result /= numbers[j];
                } else if (operand == '+') {
                    result += numbers[j];
                } else if (operand == '-') {
                    result -= numbers[j];
                } else if (operand == '^') {
                    result = Math.pow(result, numbers[j]);
                }
            } else if (isAddition || isSubtraction || isMultiplication || isDivision || isPower) {
                operand = parsedInput[i].charAt(0);
                j--;
            }

        }

        return result;
    }
}
