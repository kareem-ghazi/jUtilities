package com.kimo.advanced.calculator.singleoperational;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.MathUtils;
import com.kimo.advanced.calculator.singleoperational.utils.PrintUtils;

public class Calculator {
    Scanner scan = new Scanner(System.in);
    File file = new File("src/com/kimo/advanced/calculator/singleoperational/dump.txt");
    ArrayList<String> resultLog = new ArrayList<>();
    boolean hasDumped = false;

    public void calculationMode() {
        String userInput = "";
        String[] parsedInput;

        resultLog = new ArrayList<>();
        hasDumped = false;
        
        while (true) {
            System.out.print("-: ");
            userInput = scan.nextLine();
            parsedInput = userInput.split(" ");

            if (userInput.equals("!q")) {
                break;
            }

            System.out.println(calculateInput(parsedInput));
        }

    }

    private double calculateInput(String[] parsedInput) {
        double result = 0;
        double oldResult = 0;
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
                    oldResult = result;
                    result *= numbers[j];
                    resultLog.add(oldResult + " x " + numbers[j] + " = " + result);
                } else if (operand == '/') {
                    oldResult = result;
                    result /= numbers[j];
                    resultLog.add(oldResult + " / " + numbers[j] + " = " + result);
                } else if (operand == '+') {
                    oldResult = result;
                    result += numbers[j];
                    resultLog.add(oldResult + " + " + numbers[j] + " = " + result);
                } else if (operand == '-') {
                    oldResult = result;
                    result -= numbers[j];
                    resultLog.add(oldResult + " - " + numbers[j] + " = " + result);
                } else if (operand == '^') {
                    oldResult = result;
                    result = Math.pow(result, numbers[j]);
                    resultLog.add(oldResult + " ^ " + numbers[j] + " = " + result);
                }
            } else if (isAddition || isSubtraction || isMultiplication || isDivision || isPower) {
                operand = parsedInput[i].charAt(0);
                j--;
            }

        }

        return result;
    }

    public void dump() throws IOException {
        FileWriter myWriter = new FileWriter(file, true);
        
        if (!file.exists()) {
            file.createNewFile();
        }

        for (String string : resultLog) {

            try {
                myWriter.write(string + "\n");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        myWriter.write(PrintUtils.getSeparator() + "\n");
        System.out.println("Successfully dumped to the file.");
        hasDumped = true;
        myWriter.close();
    }
}
