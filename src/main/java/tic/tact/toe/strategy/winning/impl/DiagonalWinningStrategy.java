package tic.tact.toe.strategy.winning.impl;

import tic.tact.toe.model.Move;
import tic.tact.toe.model.Symbol;
import tic.tact.toe.strategy.winning.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    private Map<Symbol, Integer> diagonalWinningMap = new HashMap<>();
    private Map<Symbol, Integer> antiDiagonalWinningMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int n) {
        var row = move.getCell().getRow();
        var col = move.getCell().getCol();
        var symbol = move.getPlayer().getSymbol();

        if (row == col) {
            diagonalWinningMap.put(symbol, diagonalWinningMap.getOrDefault(symbol, 0) + 1);
        }

        if (row + col == n - 1) {
            antiDiagonalWinningMap.put(symbol, antiDiagonalWinningMap.getOrDefault(symbol, 0) + 1);
        }

        return (diagonalWinningMap.containsKey(symbol) && diagonalWinningMap.get(symbol) == n) || (antiDiagonalWinningMap.containsKey(symbol) && antiDiagonalWinningMap.get(symbol) == n);
    }

    @Override
    public void handleUndo(Move lastMove, int dimension) {
        var cell = lastMove.getCell();
        var symbol = cell.getPlayer().getSymbol();
        if (cell.getCol() == cell.getRow()) {
            diagonalWinningMap.put(symbol, diagonalWinningMap.get(symbol) - 1);
        }
        if (cell.getCol() + cell.getRow() == dimension - 1) {
            antiDiagonalWinningMap.put(symbol, antiDiagonalWinningMap.get(symbol) - 1);
        }
    }
}
