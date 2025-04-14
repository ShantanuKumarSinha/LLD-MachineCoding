package tic.tact.toe.strategy.bot;

import tic.tact.toe.model.Board;
import tic.tact.toe.model.Cell;

public interface BOTPlayingStrategy {

    Cell chooseCellToPlay(Board board);
}
