package com.kimo.intermediate.atm;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    
    /**
     * The name of the bank.
     */
    private String name;

    /**
     * The list of users for this bank.
     */
    private ArrayList<User> users;

    /**
     * The list of accounts for this bank.
     */
    private ArrayList<Account> accounts;
    
    /**
     * Creates a new bank with empty list of users and accounts.
     * 
     * @param name The name of the bank.
     */
    public Bank(String name) {
        this.name = name;

        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Generates a new user UUID.
     * 
     * @return A new user UUID.
     */
    public String getNewUserUUID() {
        String uuid;
        Random rng = new Random();
        int length = 6;
        boolean nonUnique;

        do {
            
            uuid = "";
            
            // Generates a new UUID.
            for (int i = 0; i < length; i++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }

            nonUnique = false;

            // Checks if the newly generated UUID is the same as one of the existing users.
            for (User user : this.users) {
                if (uuid.compareTo(user.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);
        
        return uuid;
    }

    /**
     * Generates a new account UUID.
     * 
     * @return A new account UUID.
     */
    public String getNewAccountUUID() {
        String uuid;
        Random rng = new Random();
        int length = 10;
        boolean nonUnique;

        do {
            
            uuid = "";
            
            // Generates a new UUID.
            for (int i = 0; i < length; i++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }

            nonUnique = false;

            // Checks if the newly generated UUID is the same as one of the existing accounts.
            for (Account account : this.accounts) {
                if (uuid.compareTo(account.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);
        
        return uuid;
    }
    
    /**
     * Adds an account.
     * @param account The account to be added.
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     * Adds a new user.
     * 
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param pin The pin of the user.
     */
    public User addUser(String firstName, String lastName, String pin) {
        User user = new User(firstName, lastName, pin, this);
        this.users.add(user);

        Account account = new Account("Savings", user, this);
        user.addAccount(account);
        this.accounts.add(account);

        return user;
    }

    /**
     * User login validation.
     * @param uuid The entered uuid.
     * @param pin The entered pin.
     * @return Whether the user login is valid or not.
     */
    public User userLogin(String uuid, String pin) {
        for (User user : this.users) {
            if (user.getUUID().compareTo(uuid) == 0 && user.validatePin(pin)) {
                return user;
            }
        }

        return null;
    }

    /**
     * Gets the name of the bank.
     * @return The bank's name.
     */
    public String getName() {
        return name;
    }
}
