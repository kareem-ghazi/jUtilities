package com.kimo.quizmaker;

import java.util.Scanner;

public class Application {
	Scanner scan = new Scanner(System.in);

	public void mainLoop() {
		Quiz quiz = new Quiz();

		String userInput = "";
		int parsedUserInput = 0;
		int definedQuizSize = 0;

		System.out.print("-: ");
		try {
			userInput = scan.nextLine();
			parsedUserInput = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.err.println("Invalid input.");
			parsedUserInput = 0;
		}

		while (parsedUserInput != 3) {
			switch (parsedUserInput) {
			case 1:
				System.out.print("Enter the number of questions: ");
				definedQuizSize = scan.nextInt();
				quiz.createQuiz(definedQuizSize);
				scan.nextLine(); // Discards scanner buffer of scan.nextInt();
				break;
			case 2:
				if (definedQuizSize != 0) {
					quiz.playQuiz(definedQuizSize);
					break;
				}
				System.err.println("You have made no quizzes yet!");
			default:

			}

			printSeparator();
			printCommandList();
			System.out.print("-: ");
			try {
				userInput = scan.nextLine();
				parsedUserInput = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				System.err.println("Invalid input.");
				parsedUserInput = 0;
			}

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
