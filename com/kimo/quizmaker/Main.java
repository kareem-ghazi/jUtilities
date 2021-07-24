package com.kimo.quizmaker;

public class Main {

	public static void main(String[] args) {
		Application application = new Application();
		
		application.printSeparator();
		System.out.println("Quiz Maker - Creates randomized quizzes!");
		application.printCommandList();
		application.mainLoop();
		application.printSeparator();
		
		
	}

}
