package com.kimo.beginner.salessearcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SalesSearcher {
    private static ArrayList<String> regions = new ArrayList<>();
    private static ArrayList<String> countries = new ArrayList<>();
    private static ArrayList<String> itemTypes = new ArrayList<>();
    private static ArrayList<String> orderDates = new ArrayList<>();
    private static ArrayList<Integer> orderIDs = new ArrayList<>();
    private static ArrayList<Integer> unitsSold = new ArrayList<>();
    private static ArrayList<Double> unitsPrice = new ArrayList<>();
    private static ArrayList<Double> totalRevenues = new ArrayList<>();
    
    private static NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);

    public void readFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                regions.add(values[0]);
                countries.add(values[1]);
                itemTypes.add(values[2]);
                orderDates.add(values[3]);
                orderIDs.add(Integer.parseInt(values[4]));
                unitsSold.add(Integer.parseInt(values[5]));
                unitsPrice.add(Double.parseDouble(values[6]));
                totalRevenues.add(Double.parseDouble(values[7]));
            }
        } catch (NumberFormatException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }

    public void printOrderDetails(String orderID) {
        if (orderIDs.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("You have not read a file yet.");
            return;
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < orderIDs.size(); i++) {
            if (orderIDs.get(i).equals(Integer.parseInt(orderID))) {
                System.out.println("----------------------------");
                System.out.println("Region: " + regions.get(i));
                System.out.println("Country: " + countries.get(i));
                System.out.println("Item type: " + itemTypes.get(i));
                System.out.println("Order date: " + orderDates.get(i));
                System.out.println("Order ID: " + orderIDs.get(i));
                System.out.println("Units sold: " + unitsSold.get(i));
                System.out.println("Units price: $" + numberFormat.format(unitsPrice.get(i)));
                System.out.println("Total revenue: $" + numberFormat.format(totalRevenues.get(i)));
                System.out.println("----------------------------");
                break;
            }

        }
        
        System.out.println("TIME TAKEN: " + (System.currentTimeMillis() - start) + "ms");
    }
}