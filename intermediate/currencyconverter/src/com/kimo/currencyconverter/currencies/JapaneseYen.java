package com.kimo.currencyconverter.currencies;

import com.kimo.currencyconverter.Currency;

public class JapaneseYen extends Currency {

    @Override
    public double getValue() {
        return 109.65;
    }

    @Override
    public String getName() {
        return "JAPANESE_YEN";
    }

    @Override
    public String getSymbol() {
        return "¥";
    }

    @Override
    public String getISOCode() {
        return "JPY";
    }
    
}
