package com.kimo.intermediate.currenyconverter;

public class Converter {
    
    public static Converter getInstance() {
        return new Converter();
    }

    public double convert(Currency fromCurrency, Currency toCurrency, double amount) {
        double newAmount = (toCurrency.getValue() / fromCurrency.getValue()) * amount;

        return newAmount;
    }
}
