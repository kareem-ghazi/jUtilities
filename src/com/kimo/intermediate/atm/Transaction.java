package com.kimo.intermediate.atm;

import java.util.Date;

public class Transaction {
    
    /**
     * The amount for this transaction.
     */
    private double amount;

    /**
     * The time of this transaction.
     */
    private Date timeStamp;

    /**
     * The memo for this transaction.
     */
    private String memo;

    /**
     * The account that performed this transaction.
     */
    private Account account;

    /**
     * Create a new transaction.
     * 
     * @param amount The amount transacted.
     * @param account The account where the transaction took place.
     */
    public Transaction(double amount, Account account) {
        this.amount = amount;
        this.account = account;
        this.timeStamp = new Date();

        this.memo = "";
    }

    /**
     * Create a new transaction.
     * 
     * @param amount The amount transacted.
     * @param account The account where the transaction took place.
     * @param memo The memo for the transaction.
     */
    public Transaction(double amount, String memo, Account account) {
        this(amount, account);

        this.memo = memo;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getSummaryLine() {
        if (this.amount >= 0) {
            return String.format("%s : $%.02f : %s", this.timeStamp.toString(), this.amount, this.memo);
        } else {
            return String.format("%s : $(%.02f) : %s", this.timeStamp.toString(), this.amount, this.memo);
        }
    }  
}
