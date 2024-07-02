package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

public class Pawn extends Piece {
    private Color color;
    private final Type TYPE = Type.PAWN;
    private int xPos;
    private int yPos;

    public Pawn() {
        this.xPos = 0;
        this.yPos = 0;
        this.color = Color.WHITE;
    }

    public Pawn(int xPos, int yPos, Color color, ChessGame chessGame) {
        super(chessGame);
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public Pawn(Pawn otherPawn) {
        this.xPos = otherPawn.xPos;
        this.yPos = otherPawn.yPos;
        this.color = otherPawn.color;
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
        /*
            E  C  E
               p
         */
        if (this.color == Color.WHITE) {
            if (xDiff == 0 && yDiff == -1)
                return true;
            else return false;
        }
        else {
            if (xDiff == 0 && yDiff == 1)
                return true;
            else return false;
        }
    }
}
