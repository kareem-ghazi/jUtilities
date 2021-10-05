package com.kimo.tictactoe;

import java.util.ArrayList;

public class Player {
    private String name;

    private char symbol;

    private ArrayList<String> positions;

    private int wins;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.positions = new ArrayList<>();
    } 

    public String getName() {
        return name;
    }
    
    public char getSymbol() {
        return symbol;
    }

    public ArrayList<String> getPositions() {
        return positions;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        this.wins++;
    }

    public void clearPositions() {
        this.positions.clear();
    }

    public void clearWins() {
        this.wins = 0;
    }
}
