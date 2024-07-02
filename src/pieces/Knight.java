package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

import static java.lang.Math.abs;

public class Knight extends Piece {
    private Color color;
    private final Type TYPE = Type.KNIGHT;
    private int xPos;
    private int yPos;

    public Knight() {
        this.xPos = 0;
        this.yPos = 0;
        this.color = Color.WHITE;
    }

    public Knight(int xPos, int yPos, Color color, ChessGame chessGame) {
        super(chessGame);
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public Knight(Knight otherKnight) {
        this.xPos = otherKnight.xPos;
        this.yPos = otherKnight.yPos;
        this.color = otherKnight.color;
    }

    @Override
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    @Override
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Type getType() {
        return this.TYPE;
    }

    @Override
    public boolean isValid(int wantX, int wantY) {
        int xDiff = wantX - this.xPos;
        int yDiff = wantY - this.yPos;

        if (abs(xDiff) == 1 && abs(yDiff) == 2)
            return true;
        else if (abs(xDiff) == 2 && abs(yDiff) == 1)
            return true;
        else return false;
    }
}
