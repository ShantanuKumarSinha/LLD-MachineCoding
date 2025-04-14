package tic.tact.toe.strategy.winning;

import tic.tact.toe.model.Move;

public interface WinningStrategy {

    public boolean checkWinner(Move move, int n);

    void handleUndo(Move lastMove, int dimensiom);
}
