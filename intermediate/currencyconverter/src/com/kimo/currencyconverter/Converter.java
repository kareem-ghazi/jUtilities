package com.kimo.currencyconverter;

public class Converter {

    public double convert(Currency fromCurrency, Currency toCurrency, double amount) {
        double newAmount = (toCurrency.getValue() / fromCurrency.getValue()) * amount;

        return newAmount;
    }
}
