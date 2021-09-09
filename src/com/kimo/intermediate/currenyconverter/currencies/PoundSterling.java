package com.kimo.intermediate.currenyconverter.currencies;

import com.kimo.intermediate.currenyconverter.Currency;

public class PoundSterling extends Currency {

    @Override
    public double getValue() {
        return 0.72;
    }

    @Override
    public String getName() {
        return "POUND_STERLING";
    }

    @Override
    public String getSymbol() {
        return "£";
    }

    @Override
    public String getISOCode() {
        return "GBP";
    }
    
}
