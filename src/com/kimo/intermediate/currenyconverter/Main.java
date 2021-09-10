package com.kimo.intermediate.currenyconverter;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kimo.intermediate.currenyconverter.exceptions.NoSuchCurrencyException;
import com.kimo.intermediate.currenyconverter.utils.FormatUtils;
import com.kimo.intermediate.currenyconverter.utils.InputUtils;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mainMenu();
        }
    }

    private static void mainMenu() {
        printOptionList();
        System.out.print("-: ");
        int input = InputUtils.getCaughtIntInput(scan);

        switch (input) {
            case 1:
                scan.nextLine();
                getConversionMenu();
                break;
            case 2:
                scan.nextLine();
                getInformationMenu();
                break;
            case 3:
                printSupportedCurrencies();
                break;
            case 4:
                System.out.println("Exited program successfully.");
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
    }

    private static void getConversionMenu() {
        Converter currencyConverter = new Converter();

        Currency fromCurrency;
        Currency toCurrency;
        double amount;
        double newAmount;

        while (true) {
            try {
                System.out.print("Enter the currency to convert from: ");
                fromCurrency = Currency.getInstance(scan.nextLine());
                break;
            } catch (NoSuchCurrencyException e) {
                System.out.println("Invalid currency, please try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the currency to convert to: ");
                toCurrency = Currency.getInstance(scan.nextLine());
                break;
            } catch (NoSuchCurrencyException e) {
                System.out.println("Invalid currency, please try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the amount: ");
                amount = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid amount, please try again.");
                scan.nextLine();
            }
        }

        newAmount = currencyConverter.convert(fromCurrency, toCurrency, amount);

        printConversionSummary(fromCurrency, toCurrency, amount, newAmount);
    }

    private static void getInformationMenu() {
        Currency currency;

        while (true) {
            try {
                System.out.print("Enter the currency to get information from: ");
                currency = Currency.getInstance(scan.nextLine());
                break;
            } catch (NoSuchCurrencyException e) {
                System.out.println("Invalid currency, please try again.");
            }
        }

        currency.printSummary();
    }

    private static void printConversionSummary(Currency fromCurrency, Currency toCurrency, double amount,
            double newAmount) {
        FormatUtils.printSeparator();
        System.out.println("Conversion Summary");
        System.out.printf("\nCurrencies: %s (%s) -> %s (%s)", fromCurrency.getName(), fromCurrency.getISOCode(),
                toCurrency.getName(), toCurrency.getISOCode());
        System.out.printf("\nAmounts: %.02f (%s) -> %.02f (%s)\n", amount, fromCurrency.getSymbol(), newAmount,
                toCurrency.getSymbol());
    }

    private static void printSupportedCurrencies() {
        FormatUtils.printSeparator();
        System.out.println("Supported Currencies\n");
        for (Currency currency : Currency.getSupportedCurrencies()) {
            System.out.printf("> %s : (%s)\n", currency.getName(), currency.getISOCode());
        }
    }

    private static void printOptionList() {
        FormatUtils.printSeparator();
        System.out.println("1. Convert a currency.");
        System.out.println("2. Get information about a currency.");
        System.out.println("3. Print supported currencies.");
        System.out.println("4. Exit.");
    }

}
