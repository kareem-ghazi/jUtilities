package com.kimo.todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

	}

class Application {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> userList = new ArrayList<>();
	static String definedCommand;
	
	
	public static void start() {
		printInstructions();
		mainLoop();
	}
	
	public static void printInstructions()  {
		System.out.println("ToDoList Creator - Create to do lists using Java.");
		System.out.println("Type '!help' to view all commands.");
	}
	
	public static void mainLoop() {
		while (true) {
			@SuppressWarnings("unused")
			String userInput = readCommand();
			
		}
	}
	
	public static String readCommand() {
		return scan.nextLine();
	}
	
	}
}
