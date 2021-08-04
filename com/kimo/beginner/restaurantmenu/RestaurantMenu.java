package com.kimo.beginner.restaurantmenu;

import java.util.Scanner;

public class RestaurantMenu {
	static String[] menuItems = new String[3];
	static Scanner userInput = new Scanner(System.in);
	static String returnedResponse;
	
	public static void createMenu() {
		
		System.out.println("Enter your first menu item: ");
		menuItems[0] = userInput.next();
		
		System.out.println("Enter your second menu item: ");
		menuItems[1] = userInput.next();
		
		System.out.println("Enter your third menu item: ");
		menuItems[2] = userInput.next();
	}
	
	public static String orderFromMenu() {
		System.out.println("Great, you are done with your menu!");
		System.out.println("1. Order from menu.");
		System.out.println("2. Exit.");
		
		if (userInput.nextInt() == 1) {
			System.out.println("Alright, choose from one of your menu items: ");
			System.out.println("1. " + menuItems[0]);
			System.out.println("2. " + menuItems[1]);
			System.out.println("3. " + menuItems[2]);
			int selectedOption = userInput.nextInt();
			
			switch (selectedOption) {
			case 1:
				System.out.println("Preparing your order, please wait...");
				catchInterruptedException();
				returnedResponse = "Enjoy your " + menuItems[0] + ".";
				break;
			case 2:
				System.out.println("Preparing your order, please wait...");
				catchInterruptedException();
				returnedResponse = "Enjoy your " + menuItems[1] + ".";
				break;
			case 3:
				System.out.println("Preparing your order, please wait...");
				catchInterruptedException();
				returnedResponse = "Enjoy your " + menuItems[2] + ".";
				break;
			}
				
		} else if (userInput.nextInt() == 2) {
			System.out.println("Alright, have a great day!");
		}
		return returnedResponse;
	}
	
	public static void main(String[] args) {
		createMenu();
		System.out.println(orderFromMenu());
		
	}
	
	public static void catchInterruptedException() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("An error has occured.");
		}
	}

}


