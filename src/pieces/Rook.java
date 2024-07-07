package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

public class Rook extends Piece {
    private Color color;
    private final Type TYPE = Type.ROOK;
    private int xPos;
    private int yPos;// x value (a-h) is i, y value (1-8) is j

    public Rook() {
        this.xPos = 0;
        this.yPos = 0;
        this.color = Color.WHITE;
    }

    public Rook(int xPos, int yPos, Color color, ChessGame chessGame) {
        super(chessGame, color == Color.WHITE ? "images/Chess_rlt60.png" : "images/Chess_rdt60.png");
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public Rook(Rook otherRook) {
        this.xPos = otherRook.xPos;
        this.yPos = otherRook.yPos;
        this.color = otherRook.color;
        this.chessGame = otherRook.chessGame;
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

    @Override
    public boolean isValid(int wantX, int wantY) {
        // rook is moving right i.e. not up (+y), not left(-x), not down(-y), only right(+x)
        // rook is moving left i.e. not up (+y), not right(+x), not down(-y), only left (-x)
        // rook is moving up i.e. not down(-y), not left(-x), not right(+x), only up (+y)
        // rook is moving down i.e. not up (+y), not left(-x), not right(+x), only down (-y)
        if (wantX > xPos && wantY == yPos)
            return true;
        else if (wantX < xPos && wantY == yPos)
            return true;
        else if (wantY > yPos && wantX == xPos)
            return true;
        else if (wantY < yPos && wantX == xPos)
            return true;
        else return false;
    }

    @Override
    public boolean pieceInBetween(int wantX, int wantY) {
        return false;
    }
}
