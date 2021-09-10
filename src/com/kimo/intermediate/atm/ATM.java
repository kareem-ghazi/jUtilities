package com.kimo.intermediate.atm;

import java.util.Scanner;

public class ATM {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Example values.
        Bank drausin = new Bank("Bank of Drausin");
        User kareem = drausin.addUser("Kareem", "Ghazi", "0000");
        Account checking = new Account("Checking", kareem, drausin);
        
        kareem.addAccount(checking);
        drausin.addAccount(checking);

        User currentUser;

        // Main menu loop.
        while (true) {
            currentUser = mainMenuPrompt(drausin);
            getUserMenu(currentUser);
        }
    }

    /**
     * Print the ATM's login menu.
     * 
     * @param bank The bank to use.
     * @return The authenticated user.
     */
    public static User mainMenuPrompt(Bank bank) {
        String uuid;
        String pin;
        User authenticateUser;

        // The user login loop for authenticating the user.
        do {
            System.out.printf("\n\nWelcome to %s\n\n", bank.getName());
            System.out.print("Enter the user ID: ");
            uuid = scan.nextLine();

            System.out.print("Enter the pin: ");
            pin = scan.nextLine();

            authenticateUser = bank.userLogin(uuid, pin);

            if (authenticateUser == null) {
                System.out.println("Incorrect user ID/pin combination, please try again.");
            }

        } while (authenticateUser == null);

        return authenticateUser;
    }

    /**
     * Gets the user's menu.
     * @param user The user for this menu.
     */
    public static void getUserMenu(User user) {
        int choice;

        user.printAccountsSummary();

        // User menu loop for dealing with user's accounts.
        do {
            System.out.printf("Welcome %s, what would you like to do?\n", user.getFirstName());
            System.out.println(" 1) Show account transaction history.");
            System.out.println(" 2) Withdraw.");
            System.out.println(" 3) Deposit.");
            System.out.println(" 4) Transfer.");
            System.out.println(" 5) Print accounts summary.");
            System.out.println(" 6) Quit.");
            System.out.println();

            System.out.print("Enter choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    showTransactionHistory(user);
                    break;
                case 2:
                    withdrawFunds(user);
                    break;
                case 3:
                    depositFunds(user);
                    break;
                case 4:
                    transferFunds(user);
                    break;
                case 5:
                    user.printAccountsSummary();
                    break;
                case 6:
                    scan.nextLine();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

        } while (true);
    }

    /**
     * Shows transaction history for the user.
     * @param user The user to show the transaction history for.
     */
    private static void showTransactionHistory(User user) {
        int account;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nwhose transactions you want to see: ",
                    user.getNumberOfAccounts());
            account = scan.nextInt() - 1;

            if (account < 0 || account >= user.getNumberOfAccounts()) {
                System.out.println("Invalid account, please try again.");
            }

        } while (account < 0 || account >= user.getNumberOfAccounts());

        user.printAccountTransactionHistory(account);
    }

    /**
     * Transfer funds from one account to the other.
     * @param user The user that transfers the funds.
     */
    private static void transferFunds(User user) {
        int fromAccount;
        int toAccount;
        double amount;
        double accountBalance;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nto transfer from: ", user.getNumberOfAccounts());
            fromAccount = scan.nextInt() - 1;

            if (fromAccount < 0 || fromAccount >= user.getNumberOfAccounts()) {
                System.out.println("Invalid account, please try again.");
            }

        } while (fromAccount < 0 || fromAccount >= user.getNumberOfAccounts());

        accountBalance = user.getAccountBalance(fromAccount);

        do {
            System.out.printf("Enter the number (1-%d) of the account\nto transfer to: ", user.getNumberOfAccounts());
            toAccount = scan.nextInt() - 1;

            if (toAccount < 0 || toAccount >= user.getNumberOfAccounts()) {
                System.out.println("Invalid account, please try again.");
            }

        } while (toAccount < 0 || toAccount >= user.getNumberOfAccounts());

        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $", accountBalance);
            amount = scan.nextDouble();

            if (amount < 0) {
                System.out.println("Amount must be greater than 0.");
            } else if (amount > accountBalance) {
                System.out.printf("Amount must not be greater than\nbalance of $%.02f\n", accountBalance);
            }
        } while (amount < 0 || amount > accountBalance);

        user.transfer(fromAccount, toAccount, amount);
    }

    /**
     * Withdraw funds from an account.
     * @param user The user that withdraws the funds.
     */
    private static void withdrawFunds(User user) {
        int fromAccount;
        double amount;
        double accountBalance;
        String memo;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nto withdraw from: ", user.getNumberOfAccounts());
            fromAccount = scan.nextInt() - 1;

            if (fromAccount < 0 || fromAccount >= user.getNumberOfAccounts()) {
                System.out.println("Invalid account, please try again.");
            }

        } while (fromAccount < 0 || fromAccount >= user.getNumberOfAccounts());

        accountBalance = user.getAccountBalance(fromAccount);

        do {
            System.out.printf("Enter the amount to withdraw (max $%.02f): $", accountBalance);
            amount = scan.nextDouble();

            if (amount < 0) {
                System.out.println("Amount must be greater than 0.");
            } else if (amount > accountBalance) {
                System.out.printf("Amount must not be greater than\nbalance of $%.02f\n", accountBalance);
            }
        } while (amount < 0 || amount > accountBalance);

        scan.nextLine();

        System.out.print("Enter a memo: ");
        memo = scan.nextLine();

        user.withdraw(fromAccount, amount, memo);
    }

    /**
     * Deposits funds.
     * @param user The user that deposits the funds.
     */
    private static void depositFunds(User user) {
        int toAccount;
        double amount;
        double accountBalance;
        String memo;

        do {
            System.out.printf("Enter the number (1-%d) of the account\nto deposit in: ", user.getNumberOfAccounts());
            toAccount = scan.nextInt() - 1;

            if (toAccount < 0 || toAccount >= user.getNumberOfAccounts()) {
                System.out.println("Invalid account, please try again.");
            }

        } while (toAccount < 0 || toAccount >= user.getNumberOfAccounts());

        accountBalance = user.getAccountBalance(toAccount);

        do {
            System.out.printf("Enter the amount to deposit (max $%.02f): $", accountBalance);
            amount = scan.nextDouble();

            if (amount < 0) {
                System.out.println("Amount must be greater than 0.");
            }

        } while (amount < 0);

        scan.nextLine();

        System.out.print("Enter a memo: ");
        memo = scan.nextLine();

        user.deposit(toAccount, amount, memo);
    }
}
