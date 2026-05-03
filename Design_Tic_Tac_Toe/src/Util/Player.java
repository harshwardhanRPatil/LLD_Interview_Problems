package Util;

import CommonEnum.Symbol;
import PlayerStrategies.PlayerStrategy;


    /*
        So we can make a player call and then we give them a Symbol and the we give thema strategy
        so if a human is strategy the we have to make the call if i select human then we take huma input else we go for AI that is random
        so it like playerX.getPlayerStrategy().makeMove() -> this way we make the place
    */
public class Player {

    Symbol symbol;
    PlayerStrategy playerStrategy;

    public Player (Symbol symbol , PlayerStrategy playerStrategy){
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public PlayerStrategy getPlayerStrategy(){
        return playerStrategy;
    }
}
