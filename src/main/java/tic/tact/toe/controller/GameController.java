package tic.tact.toe.controller;

import tic.tact.toe.model.Game;
import tic.tact.toe.model.Player;
import tic.tact.toe.exception.BOTCountInvalidException;
import tic.tact.toe.exception.PlayerCountNotValidException;
import tic.tact.toe.strategy.winning.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws BOTCountInvalidException, PlayerCountNotValidException {
      return Game.builder().setDimension(dimension).setPlayerList(players).setWinningStrategies(winningStrategies).build();
    }

    public void makeMove(Game game){
        game.makeMove();

    }


    public void unDo(Game game){
        game.undo();

    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
