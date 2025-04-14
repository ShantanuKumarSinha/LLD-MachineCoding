package tic.tact.toe.strategy.bot.impl;

import tic.tact.toe.enums.CellState;
import tic.tact.toe.model.Board;
import tic.tact.toe.model.Cell;
import tic.tact.toe.strategy.bot.BOTPlayingStrategy;

public class EasyBOTPlayingStrategy implements BOTPlayingStrategy {
    @Override
    public Cell chooseCellToPlay(Board board) {
        for (var cells : board.getBoard()) {
            for (var cell : cells) {
                if (cell.getCellState().equals(CellState.EMPTY))
                    return cell;
            }
        }
        return null;
    }
}
