package com.kimo.intermediate.currenyconverter.currencies;

import com.kimo.intermediate.currenyconverter.Currency;

public class SaudiRiyal extends Currency {

    @Override
    public double getValue() {
        return 3.75;
    }

    @Override
    public String getName() {
        return "SAUDI_RIYAL";
    }

    @Override
    public String getSymbol() {
        return "﷼";
    }

    @Override
    public String getISOCode() {
        return "SAR";
    }

}
