package com.kimo.advanced.calculator.singleoperational;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kimo.advanced.calculator.singleoperational.utils.MathUtils;

public class Calculator {
    private Scanner scan = new Scanner(System.in);
    private File file = new File("src/com/kimo/advanced/calculator/singleoperational/dump.txt");
    private ArrayList<String> resultLog = new ArrayList<>();

    private boolean hasDumped = false;
    private int sessionID = 0;

    public void calculationMode() {
        String userInput = "";

        resultLog = new ArrayList<>();
        hasDumped = false;
        sessionID++;

        while (true) {
            ArrayList<String> parsedInput = new ArrayList<>();

            System.out.print("-: ");
            userInput = scan.nextLine();

            if (userInput.equals("!q")) {
                break;
            }

            Collections.addAll(parsedInput, userInput.replaceAll("\\s|[A-Za-z]", "").split(
                    "((?<=%)|(?=%))|((?<=-)|(?=-))|((?<=\\+)|(?=\\+))|((?<=\\/)|(?=\\/))|((?<=\\*)|(?=\\*))|((?<=\\^)|(?=\\^))"));

            System.out.println(calculateInput(parsedInput));
        }

    }

    private double calculateInput(ArrayList<String> parsedInput) {
        double result = 0;
        double oldResult = 0;

        ArrayList<Double> numbers = new ArrayList<>();
        String currentOperand = "";

        for (int i = 0, j = 0; i < parsedInput.size(); i++, j++) {
            boolean isAddition = parsedInput.get(i).equals("+");
            boolean isSubtraction = parsedInput.get(i).equals("-");
            boolean isMultiplication = parsedInput.get(i).equals("*");
            boolean isDivision = parsedInput.get(i).equals("/");
            boolean isPower = parsedInput.get(i).equals("^");
            boolean isModulus = parsedInput.get(i).equals("%");

            if (MathUtils.isNumeric(parsedInput.get(i))) {
                numbers.add(Double.parseDouble(parsedInput.get(i)));

                if (j == 0) {
                    result = numbers.get(0);
                }

                oldResult = result;

                switch (currentOperand) {
                    case "*":
                        result *= numbers.get(j);
                        resultLog.add(oldResult + " x " + numbers.get(j) + " = " + result);
                        break;
                    case "/":
                        result /= numbers.get(j);
                        resultLog.add(oldResult + " / " + numbers.get(j) + " = " + result);
                        break;
                    case "+":
                        result += numbers.get(j);
                        resultLog.add(oldResult + " + " + numbers.get(j) + " = " + result);
                        break;
                    case "-":
                        result -= numbers.get(j);
                        resultLog.add(oldResult + " - " + numbers.get(j) + " = " + result);
                        break;
                    case "^":
                        result = Math.pow(result, numbers.get(j));
                        resultLog.add(oldResult + " ^ " + numbers.get(j) + " = " + result);
                        break;
                    case "%":
                        result %= numbers.get(j);
                        resultLog.add(oldResult + " % " + numbers.get(j) + " = " + result);
                        break;
                }

            } else if (isAddition || isSubtraction || isMultiplication || isDivision || isPower || isModulus) {
                currentOperand = parsedInput.get(i);
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

        if (hasDumped) {
            System.out.println("You have already dumped the previous session to the file.");
            return;
        }

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("--------------" + " (SESSION ID: " + sessionID + ") ---------------" + "\n");

        for (String string : resultLog) {
            try {
                fileWriter.write(string + "\n");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

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
