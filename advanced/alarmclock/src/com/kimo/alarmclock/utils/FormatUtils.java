package com.kimo.alarmclock.utils;

public class FormatUtils {

    public static void printSeparator(String type) {
        switch (type.toUpperCase()) {
            case "FULL":
                System.out.println("--------------------------------"); // 32
                break;
            case "HALF":
                System.out.println("----------------"); // 16
                break;
            case "QUARTER":
                System.out.println("--------"); // 8
                break;
            default:
                System.out.println("null");
                break;
        }
    }
}