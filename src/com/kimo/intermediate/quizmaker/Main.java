package com.kimo.intermediate.quizmaker;

public class Main {
	
	// Main method where the program runs.
	public static void main(String[] args) {
		Application application = new Application();

		application.printSeparator();
		System.out.println("Quiz Maker - Creates quizzes!");
		application.printCommandList();
		application.mainLoop();
		application.printSeparator();

	}

}
