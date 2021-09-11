package com.kimo.calculator.singleoperational;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kimo.calculator.singleoperational.utils.MathUtil;

public class Calculator {
    private Scanner scan = new Scanner(System.in);
    private File file = new File("src/com/kimo/advanced/calculator/singleoperational/dump.txt");
    private ArrayList<String> operationLog = new ArrayList<>();

    private boolean hasDumped = false;
    private int sessionID = 0;

    public void calculationMode() {
        String userInput = "";

        operationLog = new ArrayList<>();

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

        if (!operationLog.isEmpty()) {
            sessionID++;
            hasDumped = false;
        }

    }

    private double calculateInput(ArrayList<String> parsedInput) {
        double result = 0;
        double oldResult = 0;
        int j = 0;

        ArrayList<Double> numbers = new ArrayList<>();
        String currentOperand = "";
        
        // Add j++; after it knows it is a numeric.
        for (String string : parsedInput) {
            if (MathUtil.isNumeric(string)) {
                numbers.add(Double.parseDouble(string));

                if (numbers.size() == 1) {
                    result = numbers.get(0);
                }

                oldResult = result;

                switch (currentOperand) {
                    case "*":
                        result *= numbers.get(j);
                        operationLog.add(oldResult + " x " + numbers.get(j) + " = " + result);
                        break;
                    case "/":
                        result /= numbers.get(j);
                        operationLog.add(oldResult + " / " + numbers.get(j) + " = " + result);
                        break;
                    case "+":
                        result += numbers.get(j);
                        operationLog.add(oldResult + " + " + numbers.get(j) + " = " + result);
                        break;
                    case "-":
                        result -= numbers.get(j);
                        operationLog.add(oldResult + " - " + numbers.get(j) + " = " + result);
                        break;
                    case "^":
                        result = Math.pow(result, numbers.get(j));
                        operationLog.add(oldResult + " ^ " + numbers.get(j) + " = " + result);
                        break;
                    case "%":
                        result %= numbers.get(j);
                        operationLog.add(oldResult + " % " + numbers.get(j) + " = " + result);
                        break;
                }
                
                j++;
            } else if (MathUtil.isOperand(string)) {
                currentOperand = string;
            }
        }

        return result;
    }

    public void dump() throws IOException {
        if (operationLog.isEmpty()) {
            System.out.println("You have not done a valid calculation session yet.");
            return;
        }

        if (hasDumped) {
            System.out.println("You have already dumped the previous session to the file.");
            return;
        }

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("--------------" + " (SESSION ID: " + sessionID + ") ---------------" + "\n");

        for (String operation : operationLog) {
            try {
                fileWriter.write(operation + "\n");
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
