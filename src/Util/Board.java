package Util;

import CommonEnum.Symbol;
import Observer.BoardObserver;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static Board instance; // Singleton instance

    private final int rows=3;
    private final int columns=3;
    private Symbol[][] grid;

    private List<BoardObserver> observers = new ArrayList<>();

    private Board() {
        grid = new Symbol[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }
    public Symbol getSymbol(int r, int c) {
        return grid[r][c];
    }

    // Checks if a given position is within the bounds of the board.
    public boolean isValidMove(Position pos) {
        return pos.row >= 0 && pos.row < rows && pos.col >= 0 && pos.col < columns
                && grid[pos.row][pos.col] == Symbol.EMPTY;
    }

    // Allows players to make their moves
    public void makeMove(Position pos, Symbol symbol) {
        grid[pos.row][pos.col] = symbol;
        // Notify all observers (like your Referee) that a move happened
        for (BoardObserver observer : observers) {
            observer.onMovePlaced(pos.row, pos.col, symbol);
        }
    }
    // Determines the current state of the game by checking for
    // Rows, Columns and Diagonals for winning conditions

}
