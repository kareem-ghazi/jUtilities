package com.kimo.beginner.passwordverifier;

public class Main {
    public static void main(String[] args) {
        String password = "ANlI3o+^E{@7<";
        
        verifyPassword(password);
    }

    public static void verifyPassword(String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"; 

        if (password.matches(PASSWORD_PATTERN)) {
            System.out.println("This is a valid password! :)");
        }
    }
}
