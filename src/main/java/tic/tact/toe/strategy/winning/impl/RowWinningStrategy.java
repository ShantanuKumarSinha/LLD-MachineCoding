package tic.tact.toe.strategy.winning.impl;

import tic.tact.toe.model.Move;
import tic.tact.toe.model.Symbol;
import tic.tact.toe.strategy.winning.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    private Map<Integer, Map<Symbol, Integer>> rowWinningMap = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int n) {
        var cell = move.getCell();
        if (!rowWinningMap.containsKey(cell.getRow()))
            rowWinningMap.put(cell.getRow(), new HashMap<>());
        var map = rowWinningMap.get(cell.getRow());
        var symbol = cell.getPlayer().getSymbol();
        map.put(symbol, map.getOrDefault(symbol, 0) + 1);
        return map.get(symbol).equals(n);
    }

    @Override
    public void handleUndo(Move lastMove, int dimension) {
        var cell = lastMove.getCell();
        var symbol = cell.getPlayer().getSymbol();
        rowWinningMap.get(cell.getRow()).computeIfPresent(symbol, (k, v) -> v - 1);
    }
}
