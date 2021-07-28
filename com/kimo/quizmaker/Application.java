package com.kimo.quizmaker;

import java.util.Scanner;

public class Application {
	Scanner scan = new Scanner(System.in);

	// Main program loop.
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
				quiz.create(definedQuizSize); // Enters the quiz creation menu with the defined quiz size.
				break;
			case 2:
				if (definedQuizSize != 0) {
					points = quiz.play(definedQuizSize); // Plays the quiz firstly and then assigns the final score to
															// points after it's done.
					break;
				}
				System.err.println("You have made no quizzes yet!");
				break;
			case 3:
				// Checks whether if you have made no quiz or you haven't played it yet.
				if (definedQuizSize == 0) {
					System.err.println("You have made no quizzes yet!");

				} else if (definedQuizSize != 0) {
					if (points == -1) {
						System.err.println("You haven't played any quizzes yet!");
					} else {
						printSeparator();
						System.out.println(quiz.getReport(points)); // If there's a quiz and a play session, it prints
																	// out a report with the final score.
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

	// Prints out a command list.
	public void printCommandList() {
		System.out.println("1. Create a quiz.");
		System.out.println("2. Play the quiz.");
		System.out.println("3. Print out the report of the previous quiz.");
		System.out.println("4. Exit");

	}

	// Prints out a line separator.
	public void printSeparator() {
		System.out.println("—————————————————————————————————————");

	}

}
