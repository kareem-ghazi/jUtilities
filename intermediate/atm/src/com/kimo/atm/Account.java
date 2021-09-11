package com.kimo.atm;

import java.util.ArrayList;

public class Account {
    
    /**
     * Account's name.
     */
    private String name;

    /**
     * The UUID (Universally Unique Identifier) of the account.
     */
    private String uuid;

    /**
     * The owner of the account.
     */
    private User owner;

    /**
     * The list of transactions for the account.
     */
    private ArrayList<Transaction> transactions;

    /**
     * Creates a new account.
     * 
     * @param name The name of the account.
     * @param owner The owner (user) of the account.
     * @param bank The bank that issues the account.
     */
    public Account(String name, User owner, Bank bank) {
        // Sets the account's name.
        this.name = name;

        // Sets the account's owner.
        this.owner = owner;

        // Generates a universally unique ID for the account.
        this.uuid = bank.getNewAccountUUID();

        // Intialize transactions list.
        this.transactions = new ArrayList<Transaction>();

    }

    /**
     * Gets the uuid of the account.
     * @return The uuid of the account.
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Gets a summary line from the account.
     * @return A summary line from the account.
     */
    public String getSummaryLine() {
        
        double balance = this.getBalance();
        
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    /**
     * Gets the balance of the account.
     * @return The balance of the account.
     */
    public double getBalance() {
        double balance = 0;

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }

        return balance;
    }

    /**
     * Prints transaction history for the account.
     */
    public void printTransactionHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuid);
        
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(this.transactions.get(i).getSummaryLine());
        }

        System.out.println();
    }

    /**
     * Adds a transaction to the transaction history of the account.
     * @param amount The account in which the transaction took place.
     * @param memo The memo for the transaction.
     */
    public void addTransaction(double amount, String memo) {
        Transaction newTransaction = new Transaction(amount, memo, this);
        
        this.transactions.add(newTransaction);
    }

}
