package tic.tact.toe;

import tic.tact.toe.controller.GameController;
import tic.tact.toe.enums.BOTDifficulty;
import tic.tact.toe.enums.GameState;
import tic.tact.toe.enums.PlayerType;
import tic.tact.toe.exception.BOTCountInvalidException;
import tic.tact.toe.exception.PlayerCountNotValidException;
import tic.tact.toe.model.Bot;
import tic.tact.toe.model.Player;
import tic.tact.toe.model.Symbol;
import tic.tact.toe.strategy.winning.WinningStrategy;
import tic.tact.toe.strategy.winning.impl.ColWinningStrategy;
import tic.tact.toe.strategy.winning.impl.DiagonalWinningStrategy;
import tic.tact.toe.strategy.winning.impl.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws BOTCountInvalidException, PlayerCountNotValidException {
        Player p1 = new Player("Shantanu", new Symbol("", 'S'), PlayerType.HUMAN);
        Player p2 = new Bot("Umang", new Symbol("", 'U'), BOTDifficulty.EASY);


        List<Player> players = List.of(p1, p2);

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();

        var game = gameController.startGame(3, players, winningStrategies);

        Scanner scanner = new Scanner(System.in);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            gameController.printBoard(game);
            gameController.makeMove(game);
            if (game.getMoveList().getLast().getPlayer().getPlayerType().equals(PlayerType.HUMAN)) {
                System.out.println("Do you want to undo last move? (y/n)");
                String line = scanner.next();
                if (line.equalsIgnoreCase("y")) {
                    gameController.unDo(game);
                }
            }

        }
        if (game.getGameState().equals(GameState.ENDED)) {
            gameController.printBoard(game);
            System.out.println("Game has a winner and " + game.getWinner().getName() + " won the game!");
        } else
            System.out.println("Game ended with a draw");


        System.out.println();
    }
}
