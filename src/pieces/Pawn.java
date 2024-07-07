package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

import static java.lang.Math.abs;

public class Pawn extends Piece {
    private Color color;
    private final Type TYPE = Type.PAWN;
    private int xPos;
    private int yPos;
    private int colorOffset;

    public Pawn() {
        this.xPos = 0;
        this.yPos = 0;
        this.color = Color.WHITE;
    }

    public Pawn(int xPos, int yPos, Color color, ChessGame chessGame) {
        super(chessGame, color == Color.WHITE ? "images/Chess_plt60.png" : "images/Chess_pdt60.png");
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        if (color == Color.WHITE)
            this.colorOffset = 1;
        else this.colorOffset = -1;
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

    @Override
    public int getXPos() {
        return this.xPos;
    }

    @Override
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
           P()  P  P()
                C

                C
           P()  P  P()
         */
        if (xDiff == 2)
            return firstMoveValid(wantX, wantY);
        if (chessGame.getPiece(wantX, wantY - colorOffset) != null) // en passant
            return true;
        return isValidHelper(wantX, wantY);
    }

    public boolean firstMoveValid(int wantX, int wantY) {
        int yDiff = wantY - this.yPos;
        if (this.colorOffset == 1 && this.yPos == 1 && (yDiff == 1 || yDiff == 2) && !pieceInBetween(wantX, wantY))
            return true;
        if (this.colorOffset == -1 && this.yPos == 7 && (yDiff == -1 || yDiff == -2) && !pieceInBetween(wantX, wantY))
            return true;
        return false;
    }

    @Override
    public boolean pieceInBetween(int wantX, int wantY) {
        int yDiff = wantY - this.yPos;

        if (abs(yDiff) == 2) // there will only be a piece in between for the first move
            return chessGame.getPiece(wantX, wantY + this.colorOffset) != null;
        return false;
    }

    public boolean isValidHelper(int xDiff, int yDiff) {
        if (xDiff == -1 && yDiff == this.colorOffset)
            return true;
        if (xDiff == 1 && yDiff == this.colorOffset)
            return true;
        return xDiff == 0 && yDiff == this.colorOffset;
    }
}
