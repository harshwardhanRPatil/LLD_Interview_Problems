package PlayerStrategies;

import Util.Board;
import Util.Position;

public interface PlayerStrategy {
    Position makeMove(Board board);
}
