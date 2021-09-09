package com.kimo.intermediate.currenyconverter;

import com.kimo.intermediate.currenyconverter.currencies.EgyptianPound;
import com.kimo.intermediate.currenyconverter.currencies.USDollar;

public class Main {
    public static void main(String[] args) {
        Converter currencyConverter = Converter.getInstance();
        Currency dollar = new USDollar();
        Currency egyptianpound = new EgyptianPound();
        
        double newAmount = currencyConverter.convert(dollar, egyptianpound, 1000);
        System.out.println(newAmount);
    }
}
