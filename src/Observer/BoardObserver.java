package Observer;

import CommonEnum.Symbol;

public interface BoardObserver {
    public void onMovePlaced(int row, int col, Symbol symbol);
}
