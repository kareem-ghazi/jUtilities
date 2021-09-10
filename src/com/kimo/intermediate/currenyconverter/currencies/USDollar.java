package com.kimo.intermediate.currenyconverter.currencies;

import com.kimo.intermediate.currenyconverter.Currency;

public class USDollar extends Currency {

    @Override
    public double getValue() {
        return 1;
    }

    @Override
    public String getName() {
        return "UNITED_STATES_DOLLAR";
    }

    @Override
    public String getSymbol() {
        return "$";
    }

    @Override
    public String getISOCode() {
        return "USD";
    }

}
