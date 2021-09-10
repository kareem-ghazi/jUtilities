package com.kimo.intermediate.currenyconverter.currencies;

import com.kimo.intermediate.currenyconverter.Currency;

public class Euro extends Currency {

    @Override
    public double getValue() {
        return 0.85;
    }

    @Override
    public String getName() {
        return "EURO";
    }

    @Override
    public String getSymbol() {
        return "€";
    }

    @Override
    public String getISOCode() {
        return "EUR";
    }

}
