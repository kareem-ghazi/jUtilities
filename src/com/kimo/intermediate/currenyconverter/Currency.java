package com.kimo.intermediate.currenyconverter;

import com.kimo.intermediate.currenyconverter.currencies.CanadianDollar;
import com.kimo.intermediate.currenyconverter.currencies.EgyptianPound;
import com.kimo.intermediate.currenyconverter.currencies.Euro;
import com.kimo.intermediate.currenyconverter.currencies.JapaneseYen;
import com.kimo.intermediate.currenyconverter.currencies.PoundSterling;
import com.kimo.intermediate.currenyconverter.currencies.SaudiRiyal;
import com.kimo.intermediate.currenyconverter.currencies.USDollar;
import com.kimo.intermediate.currenyconverter.exceptions.NoSuchCurrencyException;
import com.kimo.intermediate.currenyconverter.utils.FormatUtils;

public abstract class Currency {
    private final static Currency[] supportedCurrencies = { new Euro(), new USDollar(), new EgyptianPound(),
            new CanadianDollar(), new JapaneseYen(), new PoundSterling(), new SaudiRiyal() };

    public abstract double getValue();

    public abstract String getName();

    public abstract String getSymbol();

    public abstract String getISOCode();

    public static Currency getInstance(String currency) throws NoSuchCurrencyException {
        switch (currency.toUpperCase()) {
            case "EUR":
                return new Euro();
            case "USD":
                return new USDollar();
            case "EGP":
                return new EgyptianPound();
            case "CAD":
                return new CanadianDollar();
            case "JPY":
                return new JapaneseYen();
            case "GBP":
                return new PoundSterling();
            case "SAR":
                return new SaudiRiyal();
            default:
                throw new NoSuchCurrencyException("Currency '" + currency + "' does not exist.");
        }
    }

    public static Currency[] getSupportedCurrencies() {
        return supportedCurrencies;
    }

    public void printSummary() {
        FormatUtils.printSeparator();
        System.out.println("Currency Summary");
        System.out.printf("\nName: %s", this.getName());
        System.out.printf("\n*Value: %.02f", this.getValue());
        System.out.printf("\nSymbol: %s", this.getSymbol());
        System.out.printf("\nISOCode: %s\n", this.getISOCode());
        System.out.println("\n*Value is equivalent to one united states dollar.");
    }
}
