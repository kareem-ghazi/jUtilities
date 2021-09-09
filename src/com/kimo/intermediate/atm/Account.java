package com.kimo.intermediate.atm;

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

    public String getUUID() {
        return this.uuid;
    }

    public String getSummaryLine() {
        
        double balance = this.getBalance();
        
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    public double getBalance() {
        double balance = 0;

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }

        return balance;
    }

    public void printTransactionHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuid);
        
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(this.transactions.get(i).getSummaryLine());
        }

        System.out.println();
    }

    public void addTransaction(double amount, String memo) {
        Transaction newTransaction = new Transaction(amount, memo, this);
        
        this.transactions.add(newTransaction);
    }

}
