package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    private Color color;
    private final Type TYPE = Type.BISHOP;
    private int xPos;
    private int yPos;

    public Bishop() {
        this.xPos = 0;
        this.yPos = 0;
        this.color = Color.WHITE;
    }

    public Bishop(int xPos, int yPos, Color color, ChessGame chessGame) {
        super(chessGame);
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public Bishop(Bishop otherBishop) {
        this.xPos = otherBishop.xPos;
        this.yPos = otherBishop.yPos;
        this.color = otherBishop.color;
    }

    @Override
    public void setXPos(int x) {
        this.xPos = x;
    }

    @Override
    public void setYPos(int y) {
        this.yPos = y;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Type getType() {
        return TYPE;
    }

    @Override
    public boolean isValid(int wantX, int wantY) {
        int xDiff = wantX - this.xPos;
        int yDiff = wantY - this.yPos;

        if (abs(xDiff) == abs(yDiff))
            return true;
        else return false;
    }
}
