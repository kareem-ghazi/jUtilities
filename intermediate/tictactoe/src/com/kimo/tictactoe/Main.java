package com.kimo.tictactoe;

public class Main {

    public static void main(String[] args) {
        Player kimo = new Player("Kareem", 'x');
        Player michael = new Player("Michael", 'o');
        
        Game game = new Game(kimo, michael);
        game.start();
        
        System.out.println();
    }
}
