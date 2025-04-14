package tic.tact.toe.model;

import tic.tact.toe.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<>();
        //d = 5, 5*5  , board = [[c1,c2,c3] , [...], [...]]
        //[[c1,c2,c3,c4,c5] , [.....] , [....], []. []]
        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }

    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void print() {
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                var cell = board.get(i).get(j);
                if (cell.getCellState().equals(CellState.EMPTY))
                    System.out.print("|   |");
                else
                    System.out.print("| " + cell.getPlayer().getSymbol().getSymbolChar() + " |");
            }
            System.out.println();
        }
    }
}
