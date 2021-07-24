package com.kimo.quizmaker;

import java.util.Scanner;

public class Application {
	Scanner scan = new Scanner(System.in);

	public void mainLoop() {
		Quiz quiz = new Quiz();
		System.out.print("-: ");
		String userInput = scan.nextLine();
		int parsedInput = Integer.parseInt(userInput);
		int quizSize = 0;
		while (parsedInput != 3) {
			switch (parsedInput) {
			case 1:
				System.out.print("Enter the number of questions: ");
				quizSize = scan.nextInt();
				quiz.createQuiz(userInput, quizSize);
				scan.nextLine();
				break;
				
			case 2:
				quiz.playQuiz(quizSize);
				break;
				
			default:
				System.err.println("Invalid Input.");
				
			}
			
			printSeparator();
			printCommandList();
			System.out.print("-: ");
			userInput = scan.nextLine();
			parsedInput = Integer.parseInt(userInput);
			
		}

	}

	public void printCommandList() {
		System.out.println("1. Create a quiz.");
		System.out.println("2. Play the quiz.");
		System.out.println("3. Exit");

	}

	public void printSeparator() {
		System.out.println("—————————————————————————————————————");
		
	}

}
