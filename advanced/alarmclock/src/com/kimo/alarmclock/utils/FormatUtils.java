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
            case "EMPTY":
                System.out.println();
                break;
            default:
                System.out.println("null");
                break;
        }
    }

    public static String getSeparator(String type) {
        switch (type.toUpperCase()) {
            case "FULL":
                return "--------------------------------"; // 32
            case "HALF":
                return "----------------"; // 16
            case "QUARTER":
                return "--------"; // 8
            default:
                return "null";
        }
    }
}