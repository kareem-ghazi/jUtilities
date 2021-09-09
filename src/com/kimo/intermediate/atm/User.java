package com.kimo.intermediate.atm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The last name of the user.
     */
    private String lastName;

    /**
     * The UUID (Universally Unique Identifiers) of the user.
     */
    private String uuid;

    /**
     * The MD5 hash of the user's pin.
     */
    private byte[] pinHash;

    /**
     * The list of accounts for the user.
     */
    private ArrayList<Account> accounts;

    /**
     * Creates a new user.
     * 
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param pin The user's pin.
     * @param bank The user's bank.
     */
    public User(String firstName, String lastName, String pin, Bank bank) {
        // Sets the user's first name.
        this.firstName = firstName;
        
        // Sets the user's last name.
        this.lastName = lastName;

        // Stores the pin's MD5 Hash rather than storing the pin in a plain string for security purposes.
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            this.pinHash = messageDigest.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("An error has occured: NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        // Generate a new, universally unique ID for the user.
        this.uuid = bank.getNewUserUUID();

        // Create an empty list of accounts for the user.
        this.accounts = new ArrayList<Account>();

        // A log message that prints out details about the user.
        // This also means the user creation process was successful.
        System.out.printf("New user %s, %s with ID (%s) has been created successfully.", firstName, lastName, this.uuid);  
    }

    /**
     * Add an account for the user.
     * 
     * @param account The account to be added.
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public String getUUID() {
        return this.uuid;
    }

    /**
     * Checks if the specified pin is the correct one.
     * 
     * @param pin The pin to check.
     * @return Whether if the pin is valid or not.
     */
    public boolean validatePin(String pin) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(messageDigest.digest(pin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("An error has occured: NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        return false;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void printAccountsSummary() {
        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        
        for (int a = 0; a < this.accounts.size(); a++) {
            System.out.printf(" %d) %s\n", a + 1, this.accounts.get(a).getSummaryLine());
        }
        
        System.out.println();
    }

    public int getNumberOfAccounts() {
        return this.accounts.size();
    }

    public void printAccountTransactionHistory(int accountIndex) {
        this.accounts.get(accountIndex).printTransactionHistory();
    }

    public double getAccountBalance(int account) {
        return this.accounts.get(account).getBalance();
    }

    public String getAccountUUID(int account) {
        return this.accounts.get(account).getUUID();
    }

    public void addAccountTransaction(int account, double amount, String memo) {
        this.accounts.get(account).addTransaction(amount, memo);
    }
    
    public void deposit(int toAccount, double amount, String memo) {
        this.addAccountTransaction(toAccount, amount, memo);
    }

    public void withdraw(int fromAccount, double amount, String memo) {
        this.addAccountTransaction(fromAccount, amount * -1, memo);
    }

    public void transfer(int fromAccount, int toAccount, double amount) {
        this.addAccountTransaction(fromAccount, amount * -1,
                String.format("Transfer to account %s", this.getAccountUUID(toAccount)));
        this.addAccountTransaction(toAccount, amount,
                String.format("Transfer from account %s", this.getAccountUUID(fromAccount)));
    }
}