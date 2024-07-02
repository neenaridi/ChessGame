package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

public class Queen extends Piece {
    private Color color;
    private final Type TYPE = Type.QUEEN;
    private int xPos;
    private int yPos;

    public Queen() {
        this.xPos = 0;
        this.yPos = 0;
        this.color = Color.WHITE;
    }

    public Queen(int xPos, int yPos, Color color, ChessGame chessGame) {
        super(chessGame);
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public Queen(Queen otherQueen) {
        this.xPos = otherQueen.xPos;
        this.yPos = otherQueen.yPos;
        this.color = otherQueen.color;
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

    public boolean isValid(int wantX, int wantY) {
        Rook rookRules = new Rook(this.xPos, this.yPos, this.color, this.chessGame);
        Bishop bishopRules = new Bishop(this.xPos, this.yPos, this.color, this.chessGame);

        if (rookRules.isValid(wantX, wantY) || bishopRules.isValid(wantX, wantY))
            return true;
        else return false;
    }
}
