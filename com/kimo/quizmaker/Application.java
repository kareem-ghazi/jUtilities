package com.kimo.quizmaker;

import java.util.Scanner;

public class Application {
	Scanner scan = new Scanner(System.in);

	public void mainLoop() {
		Quiz quiz = new Quiz();

		int userInput = 0;
		int definedQuizSize = 0;
		int points = -1;

		do {
			
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
			
			switch (userInput) {
			case 1:
				System.out.print("Enter the number of questions: ");
				definedQuizSize = scan.nextInt();
				quiz.createQuiz(definedQuizSize);
				break;
			case 2:
				if (definedQuizSize != 0) {
					points = quiz.playQuiz(definedQuizSize);
					break;
				}
				System.err.println("You have made no quizzes yet!");
				break;
			case 3:
				if (definedQuizSize == 0) {
					System.err.println("You have made no quizzes yet!");
					
				} else if (definedQuizSize != 0) {
					if (points == -1) {
						System.err.println("You haven't played any quizzes yet!");
					} else {
						printSeparator();
						System.out.println(quiz.getReport(points));
					}
					
				}
				break;
			case 4:
				System.out.println("Exited program successfully!");
				return;
			default:
				System.err.println("Invalid input.");
				
			}

			printSeparator();
			printCommandList();

		} while (true);

	}

	public void printCommandList() {
		System.out.println("1. Create a quiz.");
		System.out.println("2. Play the quiz.");
		System.out.println("3. Print out the report of the previous quiz.");
		System.out.println("4. Exit");

	}

	public void printSeparator() {
		System.out.println("—————————————————————————————————————");

	}

}
