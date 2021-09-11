package binarytranslator;

import java.util.Scanner;

public class BinaryTranslator {
	static Scanner scan = new Scanner(System.in);
	static int firstNumber;

	public static void main(String args[]) {
		System.out.print("Enter the decimal: ");
		firstNumber = scan.nextInt();
		decimalToBinary();
	}

	public static void decimalToBinary() {
		if (firstNumber == 0) {
			System.out.print(firstNumber);
		}
		while (firstNumber != 0) {
			int binaryNumber = firstNumber % 2;
			firstNumber = firstNumber / 2;
			System.out.print(binaryNumber);
		}
		
	}
}
