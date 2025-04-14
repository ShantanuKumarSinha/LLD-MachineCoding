package tic.tact.toe.model;

import tic.tact.toe.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol) {
        this.playerType = PlayerType.HUMAN;
        this.name = name;
        this.symbol = symbol;
    }


    public Player(String name, Symbol symbol, PlayerType playerType) {
        this(name, symbol);
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Cell chooseCellToPlay(Board board) {
        System.out.println("Enter the row number where you would like to play");
        int row = scanner.nextInt();
        System.out.println("Enter the column number where you would like to play");
        int column = scanner.nextInt();
        return new Cell(row, column);

    }

}
