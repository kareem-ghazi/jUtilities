package com.kimo.quizmaker;

import java.util.Scanner;

public class Application {
	Scanner scan = new Scanner(System.in);

	public void mainLoop() {
		Quiz quiz = new Quiz();

		int userInput = 0;
		int definedQuizSize = 0;

		System.out.print("-: ");
		try {
			userInput = scan.nextInt();
		} catch (Exception e) {
			scan.nextLine();
			userInput = 0;
			if (userInput != 0) {
				System.err.println("Invalid input.");
			}
		}

		while (userInput != 3) {
			switch (userInput) {
			case 1:
				System.out.print("Enter the number of questions: ");
				definedQuizSize = scan.nextInt();
				quiz.createQuiz(definedQuizSize);
				break;
			case 2:
				if (definedQuizSize != 0) {
					quiz.playQuiz(definedQuizSize);
					break;
				}
				System.err.println("You have made no quizzes yet!");
			default:
				System.err.println("Invalid input.");
			}

			printSeparator();
			printCommandList();
			System.out.print("-: ");
			try {
				userInput = scan.nextInt();
			} catch (Exception e) {
				scan.nextLine();
				userInput = 0;
				if (userInput != 0) {
					System.err.println("Invalid input.");
				}
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
