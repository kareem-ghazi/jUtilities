package com.kimo.intermediate.currenyconverter.currencies;

import com.kimo.intermediate.currenyconverter.Currency;

public class CanadianDollar extends Currency {

    @Override
    public double getValue() {
        return 1.26;
    }

    @Override
    public String getName() {
        return "CANADIAN_DOLLAR";
    }

    @Override
    public String getSymbol() {
        return "C$";
    }

    @Override
    public String getISOCode() {
        return "CAD";
    }
    
}
