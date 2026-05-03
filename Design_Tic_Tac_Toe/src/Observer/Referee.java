package Observer;

import CommonEnum.Symbol;
import Util.Board;

public class Referee implements BoardObserver{

    private boolean gameEnded = false;
    Board board= Board.getInstance();
    private int moveCount = 0;
    private String resultMessage = "";

    @Override
    public void onMovePlaced(int row, int col, Symbol symbol) {
        moveCount++;
        if (checkRow(row, symbol) ||
                checkColumn(col, symbol) ||
                checkDiagonals(row, col, symbol)) {

            System.out.println("Result: " + symbol + " wins!");
            // Logic to stop the game loop
            this.gameEnded = true;
            resultMessage = "Winner is: " + symbol;
        }else if(moveCount==9){
            this.gameEnded = true;
            resultMessage = "It's a Draw!";
        }
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    private boolean checkRow(int row, Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (board.getSymbol(row, i) != symbol) return false;
        }
        return true;
    }

    private boolean checkColumn(int col, Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (board.getSymbol(i,col) != symbol) return false;
        }
        return true;
    }

    private boolean checkDiagonals(int row, int col, Symbol symbol) {
        boolean win = false;

        // 1. Check Main Diagonal (0,0), (1,1), (2,2)
        if (row == col) {
            win = (board.getSymbol(0,0) == symbol &&
                    board.getSymbol(1,1) == symbol &&
                    board.getSymbol(2,2) == symbol);
        }

        if (win) return true;

        // 2. Check Anti-Diagonal (0,2), (1,1), (2,0)
        if (row + col == 2) {
            win = ( board.getSymbol(0,2) == symbol &&
                    board.getSymbol(1,1) == symbol &&
                    board.getSymbol(2,0) == symbol);
        }

        return win;
    }
    public String getResultMessage() { return resultMessage; }
}
