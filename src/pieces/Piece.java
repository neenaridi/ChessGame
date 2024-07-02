package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

public abstract class Piece {
    final int BOARD_SIZE = 8;
    protected ChessGame chessGame;

    public Piece() {

    }

    public Piece(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    public abstract boolean isValid(int x, int y);

    public abstract void setXPos(int x);

    public abstract void setYPos(int y);

    public abstract void setColor(Color color);

    public abstract Type getType();

    public abstract Color getColor();
}
