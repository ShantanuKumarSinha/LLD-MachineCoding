package tic.tact.toe.model;

import tic.tact.toe.enums.BOTDifficulty;
import tic.tact.toe.enums.PlayerType;
import tic.tact.toe.factory.BOTPlayingStrategyFactory;
import tic.tact.toe.strategy.bot.BOTPlayingStrategy;

public class Bot extends Player {

    private BOTDifficulty difficulty;
    private BOTPlayingStrategy strategy;


    public Bot(String name, Symbol symbol, BOTDifficulty difficulty) {
        super(name, symbol, PlayerType.BOT);
        this.difficulty = difficulty;
        this.strategy = BOTPlayingStrategyFactory.getBotPlayingStrategy(difficulty);

    }

    public BOTDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BOTDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public Cell chooseCellToPlay(Board board) {
        return strategy.chooseCellToPlay(board);
    }
}
