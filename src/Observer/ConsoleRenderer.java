package Observer;

import CommonEnum.Symbol;
import Util.Board;

public class ConsoleRenderer implements BoardObserver {

    @Override
    public void onMovePlaced(int row, int col, Symbol symbol) {
        printBoard();
    }

    public void printBoard() {
        Board board = Board.getInstance();
        System.out.println("\n--- Current Board ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Symbol s = board.getSymbol(i, j);
                String display = (s == Symbol.EMPTY) ? "-" : s.toString();
                System.out.print(display + " ");
            }
            System.out.println(); // Move to the next row
        }
        System.out.println("---------------------\n");
    }
}
