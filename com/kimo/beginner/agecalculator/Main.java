package com.kimo.beginner.agecalculator;

public class Main {
	
	// Main method to run application.
	public static void main(String[] args) {
		Application application = new Application();
		
		application.printInstructions();
		application.printCalculatedAge();
		application.restartPrompt();
	}
}
