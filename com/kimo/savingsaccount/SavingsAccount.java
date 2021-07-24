package com.kimo.savingsaccount;

public class SavingsAccount {
	String name;
	String bankType;
	int age;
	double balance;
	int bankTransfers = 0;

	public SavingsAccount(String firstName, int ageNumber, String bankTypeName, double initialBalance) {
		name = firstName;
		age = ageNumber;
		balance = initialBalance;
		bankType = bankTypeName;
	}

	// Checks the current balance of the user.
	public void checkBalance() {
		System.out.println("Hello, " + name + ".");
		System.out.println("Your account's balance is: " + balance + "$");
	}

	// Deposits the defined amount.
	public void deposit(double amountToDeposit) {
		if (amountToDeposit >= 100) {
			balance = amountToDeposit + balance;
			System.out.println("Your new balance after depositing is: " + balance + "$");
		} else {
			System.out.println("You need to deposit atleast 100$ onto your account.");
		}
	}

	// Withdraws the defined amount.
	public void withdraw(double amountToWithdraw) {
		if (amountToWithdraw >= 50) {
			balance = balance - amountToWithdraw;
			System.out.println("Your new balance after withdrawing is: " + balance + "$");
		} else {
			System.out.println("You need to withdraw atleast 100$ from your account.");
		}
	}

	// Transfers the defined amount to a user.
	public void bankTransfer(SavingsAccount firstBankID, SavingsAccount secondBankID, int amountToTransfer) {
		firstBankID.balance = firstBankID.balance - amountToTransfer;
		secondBankID.balance = secondBankID.balance + amountToTransfer;
		firstBankID.bankTransfers = firstBankID.bankTransfers + 1;
		System.out.println(firstBankID.name + " has transferred " + amountToTransfer + "$ to " + secondBankID.name + ".");
	}

	// Enlists details about the user.
	public String toString() {
		return "Name: " + name + "\nAge: " + age + "\nCurrent Balance: " + balance + "\nBank Type: " + bankType + "\nTransfer Count: "+ bankTransfers;
	}

	public static void main(String[] args) {
		SavingsAccount jackson = new SavingsAccount("Jackson", 18, "Diamond", 2000);
		SavingsAccount michael = new SavingsAccount("Michael", 21, "Platinum", 2000);
		
		jackson.deposit(100);
		michael.withdraw(100);
		System.out.println(jackson);
		System.out.println(michael);
		
	}
}
