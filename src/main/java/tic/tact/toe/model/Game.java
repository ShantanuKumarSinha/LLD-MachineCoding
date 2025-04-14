package tic.tact.toe.model;

import tic.tact.toe.enums.CellState;
import tic.tact.toe.enums.GameState;
import tic.tact.toe.enums.PlayerType;
import tic.tact.toe.exception.BOTCountInvalidException;
import tic.tact.toe.exception.PlayerCountNotValidException;
import tic.tact.toe.strategy.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private Player winner;
    private GameState gameState;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.playerList = playerList;
        this.moveList = new ArrayList<>();
        this.winningStrategies = winningStrategies;
        this.nextPlayerMoveIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean checkWinner(Move move) {
        Player winner = null;
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(move, board.getDimension()))
                return true;
        }
        return false;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void printBoard() {
        board.print();
    }

    public void makeMove() {
        var currentPlayer = this.getPlayerList().get(this.getNextPlayerMoveIndex());
        System.out.println("It's " + currentPlayer.getName() + "'s move");
        var dummyCell = currentPlayer.chooseCellToPlay(board);
        var row = dummyCell.getRow();
        var col = dummyCell.getCol();
        if (invalidCell(row, col) || isCellOccupied(row, col)) {
            System.out.println("It's not a valid move");
            return;
        }

        //filling the cell with right status and current player
        var cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        // executing the next move and updating the list
        var move = new Move(cell, currentPlayer);
        moveList.add(move);

        // update the next player turn index
        this.nextPlayerMoveIndex = (this.getNextPlayerMoveIndex() + 1) % this.playerList.size();

        // check if last move resulted in win for the player
        if (checkWinner(move)) {
            this.setGameState(GameState.ENDED);
            winner = currentPlayer;
        } else if (moveList.size() == board.getDimension() * board.getDimension())
            this.setGameState(GameState.DRAWN);
    }

    private boolean isCellOccupied(int row, int col) {
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED);
    }

    private boolean invalidCell(int row, int col) {
        return row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension();
    }

    public void undo() {
        if (moveList.isEmpty()) {
            System.out.println("Can't undo till a  move is present");
            return;
        }
        var lastMove = moveList.get(moveList.size() - 1);
        moveList.remove(lastMove);
        lastMove.setPlayer(null);
        lastMove.getCell().setCellState(CellState.EMPTY);
        // if game has a winner undo that also or if game has a draw undo that also
        if (gameState == GameState.ENDED) {
            setGameState(GameState.IN_PROGRESS);
            winner = null;
        } else if (gameState == GameState.DRAWN) {
            setGameState(GameState.IN_PROGRESS);
        }

        this.nextPlayerMoveIndex = (this.getNextPlayerMoveIndex() - 1 + playerList.size()) % this.playerList.size();

        for (WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.handleUndo(lastMove, board.getDimension());
        }

    }

    public static class Builder {
        private int dimension;
        private List<Player> playerList;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validatePlayerCount() throws PlayerCountNotValidException {
            if (playerList == null || playerList.isEmpty() || playerList.size() > dimension - 1)
                throw new PlayerCountNotValidException("Player's count is not equivalent to dimension - 1");

        }

        private void validateUniqueSymbol() {
            HashSet<Character> uniqueSymbols = new HashSet<>();
            for (Player player : playerList) {
                if (!uniqueSymbols.add(player.getSymbol().getSymbolChar()))
                    throw new RuntimeException("Symbols for all players are not unique");
            }
        }

        private void validateBOTcount() throws BOTCountInvalidException {
            int botCount = 0;
            for (Player player : playerList) {
                if (player.getPlayerType().equals(PlayerType.BOT)) botCount++;
            }
            if (botCount > dimension - 2) throw new BOTCountInvalidException("BOTs count is invalid");
        }

        private void validate() throws PlayerCountNotValidException, BOTCountInvalidException {
            validatePlayerCount();
            validateUniqueSymbol();
            validateBOTcount();

        }

        public Game build() throws BOTCountInvalidException, PlayerCountNotValidException {
            // perform all the validation
            validate();
            return new Game(dimension, playerList, winningStrategies);
        }

    }
}


