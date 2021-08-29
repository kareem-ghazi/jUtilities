package com.kimo.advanced.calculator.singleoperational;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.MathUtils;
import com.kimo.advanced.calculator.singleoperational.utils.PrintUtils;

public class Calculator {
    private Scanner scan = new Scanner(System.in);
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
        if (!file.exists() && resultLog.isEmpty()) {
            System.out.println("You have not done a calculation session yet.");
            return;
        }
        
        if (hasDumped()) {
            System.out.println("You have already dumped the previous session to the file.");
            return;    
        }

        FileWriter fileWriter = new FileWriter(file, true);

        for (String string : resultLog) {

            try {
                fileWriter.write(string + "\n");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        fileWriter.write(PrintUtils.getSeparator() + "\n");
        System.out.println("Successfully dumped to the file.");
        hasDumped = true;
        fileWriter.close();
    }

    public void deleteDumpFile() {
        if (file.exists()) {
            file.delete();
            hasDumped = false;
            System.out.println("File has been successfully deleted.");
        } else if (!file.exists()) {
            System.out.println("File does not exist.");
        }
    }

    public boolean hasDumped() {
        return hasDumped;
    }

}
