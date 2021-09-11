package com.kimo.calculator.singleoperational.utils;

public class MathUtil {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperand(String str) {
        boolean isAddition = str.equals("+");
        boolean isSubtraction = str.equals("-");
        boolean isDivision = str.equals("/");
        boolean isMultiplication = str.equals("*");
        boolean isPower = str.equals("^");
        boolean isModulus = str.equals("%");

        return isAddition || isSubtraction || isDivision || isMultiplication || isPower || isModulus;
    }
}
