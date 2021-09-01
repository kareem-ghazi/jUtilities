package com.kimo.advanced.calculator.singleoperational;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.MathUtils;
import com.kimo.advanced.calculator.singleoperational.utils.PrintUtils;

public class Calculator {
    private Scanner scan = new Scanner(System.in);
    private File file = new File("src/com/kimo/advanced/calculator/singleoperational/dump.txt");
    private ArrayList<String> resultLog = new ArrayList<>();

    private boolean hasDumped = false;

    public void calculationMode() {
        String userInput = "";

        resultLog = new ArrayList<>();
        hasDumped = false;

        while (true) {
            ArrayList<String> parsedInput = new ArrayList<>();

            System.out.print("-: ");
            userInput = scan.nextLine();

            if (userInput.equals("!q")) {
                break;
            }
            
            Collections.addAll(parsedInput, userInput.replaceAll("\\s|[A-Za-z]", "").split("((?<=-)|(?=-))|((?<=\\+)|(?=\\+))|((?<=\\/)|(?=\\/))|((?<=\\*)|(?=\\*))|((?<=\\^)|(?=\\^))"));
            System.out.println(parsedInput);

            System.out.println(calculateInput(parsedInput));
        }

    }

    private double calculateInput(ArrayList<String> parsedInput) {
        double result = 0;
        double oldResult = 0;
        ArrayList<Double> numbers = new ArrayList<>();
        char operand = ' ';

        boolean isAddition;
        boolean isSubtraction;
        boolean isMultiplication;
        boolean isDivision;
        boolean isPower;

        for (int i = 0, j = 0; i < parsedInput.size(); i++, j++) {
            isAddition = parsedInput.get(i).equals("+");
            isSubtraction = parsedInput.get(i).equals("-");
            isMultiplication = parsedInput.get(i).equals("*");
            isDivision = parsedInput.get(i).equals("/");
            isPower = parsedInput.get(i).equals("^");

            if (MathUtils.isNumeric(parsedInput.get(i))) {
                numbers.add(Double.parseDouble(parsedInput.get(i)));

                if (j == 0) {
                    result = numbers.get(0);
                }

                if (operand == '*') {
                    oldResult = result;
                    result *= numbers.get(j);
                    resultLog.add(oldResult + " x " + numbers.get(j) + " = " + result);
                } else if (operand == '/') {
                    oldResult = result;
                    result /= numbers.get(j);
                    resultLog.add(oldResult + " / " + numbers.get(j) + " = " + result);
                } else if (operand == '+') {
                    oldResult = result;
                    result += numbers.get(j);
                    resultLog.add(oldResult + " + " + numbers.get(j) + " = " + result);
                } else if (operand == '-') {
                    oldResult = result;
                    result -= numbers.get(j);
                    resultLog.add(oldResult + " - " + numbers.get(j) + " = " + result);
                } else if (operand == '^') {
                    oldResult = result;
                    result = Math.pow(result, numbers.get(j));
                    resultLog.add(oldResult + " ^ " + numbers.get(j) + " = " + result);
                }
            } else if (isAddition || isSubtraction || isMultiplication || isDivision || isPower) {
                operand = parsedInput.get(i).charAt(0);
                j--;
            }

            System.out.println(numbers);
        }

        return result;
    }

    public void dump() throws IOException {
        if (!file.exists() && resultLog.isEmpty()) {
            System.out.println("You have not done a calculation session yet.");
            return;
        }

        if (hasDumped) {
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
}
