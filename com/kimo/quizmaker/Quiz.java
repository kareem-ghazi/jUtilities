package com.kimo.quizmaker;

import java.util.Scanner;

public class Quiz {
	private Application application = new Application();
	
	private Scanner scan = new Scanner(System.in);
	private String[] questions;
	private String[][] answers;
	private Character[] correctAnswers;
	private char[] answerChoice = { 'A', 'B', 'C', 'D' };

	public void createQuiz(int size) {
		questions = new String[size];
		answers = new String[size][4];
		correctAnswers = new Character[size];
		
		String userInput = "";
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
				
				while (Character.toUpperCase(userInput.charAt(0)) != 'A' && Character.toUpperCase(userInput.charAt(0)) != 'B'
						&& Character.toUpperCase(userInput.charAt(0)) != 'C'
						&& Character.toUpperCase(userInput.charAt(0)) != 'D') {
					
					System.err.println("Invalid input.");
					System.out.print("-: ");
					userInput = scan.nextLine();
					
				}
				
				char upperCasedAnswer = Character.toUpperCase(userInput.charAt(0));
				correctAnswers[answerForQuestion] = upperCasedAnswer;
				answerForQuestion++;

			}

		}

	}

	public void playQuiz(int size) {
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
			String userInput = scan.nextLine();
			
			while (Character.toUpperCase(userInput.charAt(0)) != 'A' && Character.toUpperCase(userInput.charAt(0)) != 'B'
					&& Character.toUpperCase(userInput.charAt(0)) != 'C'
					&& Character.toUpperCase(userInput.charAt(0)) != 'D') {
				
				System.err.println("Invalid input.");
				System.out.print("-: ");
				userInput = scan.nextLine();
				
			}
			
			char upperCasedAnswer = Character.toUpperCase(userInput.charAt(0));
			userAnswers[outer] = upperCasedAnswer;
			
			if (userAnswers[outer] == correctAnswers[outer]) {
				points++;

			}

		}

		application.printSeparator();
		double percentage = Math.round(((points + 0.0) / questions.length) * 100);
		System.out.println("Points: " + points + "/" + questions.length + "\nPercentage: " + percentage + "%");
	}

}
