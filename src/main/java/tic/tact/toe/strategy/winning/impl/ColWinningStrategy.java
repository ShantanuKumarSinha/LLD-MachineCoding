package tic.tact.toe.strategy.winning.impl;

import tic.tact.toe.model.Move;
import tic.tact.toe.model.Symbol;
import tic.tact.toe.strategy.winning.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {
    private Map<Integer, Map<Symbol, Integer>> colWinningStrategy = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, int n) {
        var cell = move.getCell();
        if (!colWinningStrategy.containsKey(cell.getCol()))
            colWinningStrategy.put(cell.getCol(), new HashMap<>());
        var map = colWinningStrategy.get(cell.getCol());
        map.put(cell.getPlayer().getSymbol(), map.getOrDefault(cell.getPlayer().getSymbol(), 0)+1);

        return map.get(cell.getPlayer().getSymbol()).equals(n);
    }

    @Override
    public void handleUndo(Move lastMove, int dimension) {
        var cell = lastMove.getCell();
        var symbol = cell.getPlayer().getSymbol();
        colWinningStrategy.get(cell.getCol()).computeIfPresent(symbol, (k, v) -> v -1);
    }
}
