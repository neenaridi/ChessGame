package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

import static java.lang.Math.abs;

public class King extends Piece {
    private Color color;
    private final Type TYPE = Type.KING;
    private int xPos;
    private int yPos;
    private boolean inCheck;

    public King() {
        this.xPos = 0;
        this.yPos = 0;
        this.color = Color.WHITE;
    }

    public King(int xPos, int yPos, Color color, ChessGame chessGame) {
        super(chessGame, color == Color.WHITE ? "images/Chess_klt60.png" : "images/Chess_kdt60.png");
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public King(King otherKing) {
        this.xPos = otherKing.xPos;
        this.yPos = otherKing.yPos;
        this.color = otherKing.color;
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

    public void setInCheck(boolean status) {
        this.inCheck = status;
    }

    @Override
    public int getXPos() {
        return xPos;
    }

    @Override
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

    public boolean isInCheck() {
        return inCheck;
    }

    @Override
    public boolean isValid(int wantX, int wantY) {
        int xDiff = wantX - this.xPos;
        int yDiff = wantY - this.yPos;

        if (abs(xDiff) == 1 && (abs(yDiff) == 1) || yDiff == 0)
            return true;
        else if (xDiff == 0 && abs(yDiff) == 1)
            return true;
        else return false;
    }

    @Override
    public boolean pieceInBetween(int wantX, int wantY) {
        return false; // king can only move 1 space, there will never be a piece in between
    }
}
