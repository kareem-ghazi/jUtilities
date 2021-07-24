package com.kimo.quizmaker;

public class Quiz {
	Application app = new Application();
	
	String[] questions;
	String[][] answers;
	Character[] correctAnswers;
	
	public void createQuiz(String input, int size) {
		questions = new String[size];
		answers = new String[size][4];
		correctAnswers = new Character[size];
		
		int questionCount = 1;
		int k = 0;
		char[] answerChoice = { 'A', 'B', 'C', 'D' };

		for (int i = 0; questions[questions.length - 1] == null; i++, questionCount++) {
			app.printSeparator();
			System.out.print("Question # " + questionCount + " -: ");
			input = app.scan.nextLine();
			questions[i] = input;
			for (int j = 0; j < answers[i].length; j++) {
				System.out.print("Choice " + answerChoice[0 + j] + " -: ");
				input = app.scan.nextLine();
				answers[i][j] = input;

			}

			if (correctAnswers[k] == null) {
				System.out.print("Correct choice (A / B / C / D) -: ");
				input = app.scan.nextLine();
				correctAnswers[k] = input.charAt(0);
				k++;

			}
			

		}
		
	}
	
	public void playQuiz(int size) {
		char[] answerCount = { 'A', 'B', 'C', 'D' };
		int i = 0;
		int points = 0;
		for (i = 0; i < questions.length; i++) {
			app.printSeparator();
			System.out.println(questions[i]);
			
			for (int j = 0; j < answers[i].length; j++) {
				System.out.println(answerCount[0 + j] + " - " + answers[i][j]);
				
			}
			
			System.out.print("Type your choice here: ");
			String input = app.scan.nextLine();
			char[] answers = new char[size];
			answers[i] = input.charAt(0);
			
			if (answers[i] == correctAnswers[i]) {
				points++;
				
			}
			
		}
		
		app.printSeparator();
		double percentage = Math.round(((points + 0.0) / questions.length) * 100);
		System.out.println("Points: " + points + "/" + questions.length + "\nPercentage: " + percentage + "%");
	}
}
