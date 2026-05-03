package Controller;

import CommonEnum.Symbol;
import Observer.ConsoleRenderer;
import Observer.Referee;
import PlayerStrategies.PlayerStrategy;
import Util.Board;
import Util.Player;
import Util.Position;

public class TicTacToeGame implements BoardGames{

    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Referee referee;
    private ConsoleRenderer renderer;

    // with this we pass the imp this as we need to know which use is AI and human and what is size of the board
    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy oStrategy,
                         int rows, int columns){
        board = Board.getInstance();
        playerX = new Player(Symbol.X, xStrategy);
        playerO = new Player(Symbol.O, oStrategy);
        currentPlayer = playerX;
        referee= new Referee();
        renderer = new ConsoleRenderer();
        // this tell now we are auto matic cponect with teh refree as when we make the move we check if that win or not

        board.addObserver(referee);
        board.addObserver(renderer);
    }

    @Override
    public void play(){
        do{
            Position move = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            switchPlayer();
        }while(referee.isGameEnded());
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
}
