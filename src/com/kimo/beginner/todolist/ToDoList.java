package com.kimo.beginner.todolist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ToDoList {
	static Scanner userInput = new Scanner(System.in);
	static ArrayList<String> userList = new ArrayList<>();
	static String definedCommand;
	static SimpleDateFormat simpleDate;
	static Calendar currentDate;

	// Main dashboard to run commands in.
	public static void mainConsole() {
		System.out.print("-: ");
		definedCommand = userInput.nextLine();
	}
	
	// Puts you in insertion mode (adding tasks).
	public static void insertionMode() {
		while (definedCommand.equals("!exit") == false) {
			System.out.print("$ -: ");
			definedCommand = userInput.nextLine();
			userList.add(definedCommand);
		}
		userList.remove(userList.size() - 1);
	}
	
	// Views the current list.
	public static void viewList() {
		simpleDate = new SimpleDateFormat("yyyy/MM/dd");
		currentDate = Calendar.getInstance();
		System.out.println("List's Date: " + simpleDate.format(currentDate.getTime()));
		if (userList.size() == 0) {
			System.out.println("! This list currently has no tasks.");
		} else {
			for (int listSize = 0; listSize != userList.size(); listSize++) {
				userList.sort(null);
				System.out.println(listSize + 1 + ". " + userList.get(listSize));
			}
		}
	}

	// Removes the specified task number from the current list.
	public static void removeCommand() {
		System.out.print("Enter the task number you would like to remove: ");
		String definedNumber = userInput.nextLine();
		try {
			userList.remove(Integer.parseInt(definedNumber) - 1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid task number.");
		}
	}
	
	// Prints out all existing commands.
	public static void helpCommands() {
		System.out.println("!view - Prints the list you are working on.");
		System.out.println("!remove - Removes an item with the specified number from the list.");
		System.out.println("!help - Prints this message.");
		System.out.println("!exit - Exits the program or mode.");
		System.out.println("!insert - Enters insertion mode.");
		System.out.println("!complete - Completes the specified task.");
	}
	
	// Marks the specified task as complete.
	public static void markComplete() {
		System.out.print("Enter the task number you would like to mark as complete: ");
		String definedNumber = userInput.nextLine();
		try {
			String definedTask = userList.get(Integer.parseInt(definedNumber) - 1); 
			String completedTask = definedTask + " - COMPLETED";
			userList.set((Integer.parseInt(definedNumber) - 1), new String(completedTask));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid task number.");
		}
	}

	public static void main(String[] args) {
		System.out.println("ToDoList Creator - Create to do lists using Java.");
		System.out.println("Type '!help' to view all commands.");
		mainConsole();
		while (true) {
			if (definedCommand.equals("!help")) {
				helpCommands();
				mainConsole();
			} else if (definedCommand.equals("!view")) {
				viewList();
				mainConsole();
			} else if (definedCommand.equals("!exit")) {
				System.exit(0);
			} else if (definedCommand.equals("!remove")) {
				removeCommand();
				mainConsole();
			} else if (definedCommand.equals("!insert")) {
				insertionMode();
				mainConsole();
			} else if (definedCommand.equals("!complete")) {
				markComplete();
				mainConsole();
			} else {
				mainConsole();
			}
		}
	}
}