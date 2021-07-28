package com.kimo.quizmaker;

import java.util.Scanner;

public class Quiz {
	private Application application = new Application();

	private Scanner scan = new Scanner(System.in);
	private String userInput;
	private String[] questions;
	private String[][] answers;
	private Character[] correctAnswers;
	private char[] answerChoice = { 'A', 'B', 'C', 'D' };
	
	// Creates a quiz with the assigned size.
	public void create(int size) {
		questions = new String[size];
		answers = new String[size][4];
		correctAnswers = new Character[size];

		int questionCount = 1;
		int lastQuestion = questions.length - 1;
		int answerForQuestion = 0;

		for (int outer = 0; questions[lastQuestion] == null; outer++, questionCount++) {
			application.printSeparator();

			System.out.print("Question # " + questionCount + " -: ");
			userInput = scan.nextLine();
			questions[outer] = userInput;

			for (int inner = 0; inner < answers[outer].length; inner++) {
				System.out.print("Choice " + answerChoice[0 + inner] + " -: ");
				userInput = scan.nextLine();
				answers[outer][inner] = userInput;

			}

			if (correctAnswers[answerForQuestion] == null) {
				System.out.print("Correct choice (A / B / C / D) -: ");
				userInput = scan.nextLine();
				char parsedCharInput = Character.toUpperCase(userInput.charAt(0));

				while (parsedCharInput != 'A' && parsedCharInput != 'B' && parsedCharInput != 'C'
						&& parsedCharInput != 'D') {

					System.err.println("Invalid input.");
					System.out.print("-: ");
					userInput = scan.nextLine();
					parsedCharInput = Character.toUpperCase(userInput.charAt(0));
				}

				correctAnswers[answerForQuestion] = parsedCharInput;
				answerForQuestion++;

			}

		}

	}
	
	// Plays a quiz using the assigned size.
	public int play(int size) {
		int outer = 0;
		int points = 0;

		for (outer = 0; outer < questions.length; outer++) {
			application.printSeparator();
			System.out.println(questions[outer]);

			for (int inner = 0; inner < answers[outer].length; inner++) {
				System.out.println(answerChoice[0 + inner] + " - " + answers[outer][inner]);

			}

			char[] userAnswers = new char[size];
			System.out.print("Type your choice here: ");
			userInput = scan.nextLine();
			char parsedCharInput = Character.toUpperCase(userInput.charAt(0));

			while (parsedCharInput != 'A' && parsedCharInput != 'B' && parsedCharInput != 'C'
					&& parsedCharInput != 'D') {

				System.err.println("Invalid input.");
				System.out.print("-: ");
				userInput = scan.nextLine();
				parsedCharInput = Character.toUpperCase(userInput.charAt(0));
			}

			userAnswers[outer] = parsedCharInput;
			
			if (userAnswers[outer] == correctAnswers[outer]) {
				points++;

			}

		}

		application.printSeparator();
		System.out.println(getReport(points));
		return points;
	}
	
	// Prints out a score report using the final score.
	public String getReport(int points) {
		double percentage = Math.round(((points + 0.0) / questions.length) * 100);
		char grade = 0;
		
		if (percentage <= 25) {
			grade = 'F';
		} else if (percentage <= 60) {
			grade = 'D';
		} else if (percentage <= 80) {
			grade = 'C';
		} else if (percentage <= 90) {
			grade = 'B';
		} else if (percentage >= 90) {
			grade = 'A';
		}

		String report = "Points: " + points + "/" + questions.length + "\nGrade: " + grade + "\nPercentage: " + percentage + "%";
		return report;
		
	}

}
