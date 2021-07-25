package com.kimo.quizmaker;

import java.util.Scanner;

public class Application {
	Scanner scan = new Scanner(System.in);

	public void mainLoop() {
		Quiz quiz = new Quiz();
		String userInput = "";
		int parsedInput = 0;
		int quizSize = 0;

		System.out.print("-: ");
		try {
			userInput = scan.nextLine();
			parsedInput = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			System.err.println("Invalid input.");
		}

		while (parsedInput != 3) {
			switch (parsedInput) {
			case 1:
				System.out.print("Enter the number of questions: ");
				quizSize = scan.nextInt();
				quiz.createQuiz(quizSize, userInput);
				scan.nextLine();
				break;
			case 2:
				quiz.playQuiz(quizSize);
				break;
			}

			printSeparator();
			printCommandList();
			System.out.print("-: ");
			try {
				userInput = scan.nextLine();
				parsedInput = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				System.err.println("Invalid input.");
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
