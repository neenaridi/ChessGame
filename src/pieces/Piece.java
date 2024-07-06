package pieces;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {
    final int BOARD_SIZE = 8;
    protected ChessGame chessGame;
    protected ImageView imageView;

    public Piece() {

    }

    public Piece(ChessGame chessGame, String imagePath) {
        this.chessGame = chessGame;
        this.imageView = new ImageView(new Image(imagePath));
        this.imageView.setFitWidth(50);
        this.imageView.setFitHeight(50);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public abstract boolean isValid(int x, int y);

    public abstract void setXPos(int x);

    public abstract void setYPos(int y);

    public abstract void setColor(Color color);

    public abstract Type getType();

    public abstract Color getColor();

    public abstract int getXPos();

    public abstract int getYPos();
}
