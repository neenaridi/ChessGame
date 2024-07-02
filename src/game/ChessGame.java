package game;

import pieces.*;
import pieces.enums.Color;
import pieces.enums.Type;

public class ChessGame {
    private static final int BOARD_SIZE = 8;
    private static ChessGame instance;
    public static Piece[][] currentBoard = new Piece[BOARD_SIZE][BOARD_SIZE];

    private ChessGame() {
        populateBoard();
    }

    public static ChessGame getInstance() {
        if (instance == null) {
            instance = new ChessGame();
        }
        return instance;
    }

    public void populateBoard() {
        // top of board = black
        currentBoard[0][0] = new Rook(0, 0, Color.BLACK, this);
        currentBoard[1][0] = new Knight(1, 0, Color.BLACK, this);
        currentBoard[2][0] = new Bishop(2, 0, Color.BLACK, this);
        currentBoard[3][0] = new Queen(3, 0, Color.BLACK, this);
        currentBoard[4][0] = new King(4, 0, Color.BLACK, this);
        currentBoard[5][0] = new Bishop(5, 0, Color.BLACK, this);
        currentBoard[6][0] = new Knight(6, 0, Color.BLACK, this);
        currentBoard[7][0] = new Rook(7, 0, Color.BLACK, this);

        currentBoard[0][1] = new Pawn(0, 1, Color.BLACK, this);
        currentBoard[1][1] = new Pawn(1, 1, Color.BLACK, this);
        currentBoard[2][1] = new Pawn(2, 1, Color.BLACK, this);
        currentBoard[3][1] = new Pawn(3, 1, Color.BLACK, this);
        currentBoard[4][1] = new Pawn(4, 1, Color.BLACK, this);
        currentBoard[5][1] = new Pawn(5, 1, Color.BLACK, this);
        currentBoard[6][1] = new Pawn(6, 1, Color.BLACK, this);
        currentBoard[7][1] = new Pawn(7, 1, Color.BLACK, this);

        // bottom of board = white
        currentBoard[0][7] = new Rook(0, 7, Color.WHITE, this);
        currentBoard[1][7] = new Knight(1, 7, Color.WHITE, this);
        currentBoard[2][7] = new Bishop(2, 7, Color.WHITE, this);
        currentBoard[3][7] = new Queen(3, 7, Color.WHITE, this);
        currentBoard[4][7] = new King(4, 7, Color.WHITE, this);
        currentBoard[5][7] = new Bishop(5, 7, Color.WHITE, this);
        currentBoard[6][7] = new Knight(6, 7, Color.WHITE, this);
        currentBoard[7][7] = new Rook(7, 7, Color.WHITE, this);

        currentBoard[0][6] = new Pawn(0, 6, Color.WHITE, this);
        currentBoard[1][6] = new Pawn(1, 6, Color.WHITE, this);
        currentBoard[2][6] = new Pawn(2, 6, Color.WHITE, this);
        currentBoard[3][6] = new Pawn(3, 6, Color.WHITE, this);
        currentBoard[4][6] = new Pawn(4, 6, Color.WHITE, this);
        currentBoard[5][6] = new Pawn(5, 6, Color.WHITE, this);
        currentBoard[6][6] = new Pawn(6, 6, Color.WHITE, this);
        currentBoard[7][6] = new Pawn(7, 6, Color.WHITE, this);

        // empty positions
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 2; j < 6; j++) {
                currentBoard[i][j] = null;
            }
        }
    }

    public Piece getPiece(int x, int y) {
        return currentBoard[x][y];
    }

    public boolean friendlyCollision(int pieceX, int pieceY, int wantX, int wantY) {
        return (currentBoard[pieceX][pieceY].getColor() == currentBoard[wantX][wantY].getColor());
    }

    public void movePiece(int pieceX, int pieceY, int wantX, int wantY) {
        boolean friendlyMove, validPieceMove;

        if (currentBoard[wantX][wantY] != null)
            friendlyMove = friendlyCollision(pieceX, pieceY, wantX, wantY);
        else friendlyMove = false;
        validPieceMove = currentBoard[pieceX][pieceY].isValid(wantX, wantY);

        if (!friendlyMove && validPieceMove) {
            if (currentBoard[pieceX][pieceY].getType() == Type.ROOK) {
                currentBoard[wantX][wantY] = new Rook((Rook) currentBoard[pieceX][pieceY]);
            } else if (currentBoard[pieceX][pieceY].getType() == Type.KNIGHT) {
                currentBoard[wantX][wantY] = new Knight((Knight) currentBoard[pieceX][pieceY]);
            } else if (currentBoard[pieceX][pieceY].getType() == Type.BISHOP) {
                currentBoard[wantX][wantY] = new Bishop((Bishop) currentBoard[pieceX][pieceY]);
            } else if (currentBoard[pieceX][pieceY].getType() == Type.KING) {
                currentBoard[wantX][wantY] = new King((King) currentBoard[pieceX][pieceY]);
            } else if (currentBoard[pieceX][pieceY].getType() == Type.QUEEN) {
                currentBoard[wantX][wantY] = new Queen((Queen) currentBoard[pieceX][pieceY]);
            } else if (currentBoard[pieceX][pieceY].getType() == Type.PAWN) {
                currentBoard[wantX][wantY] = new Pawn((Pawn) currentBoard[pieceX][pieceY]);
            }
            currentBoard[wantX][wantY].setXPos(wantX);
            currentBoard[wantX][wantY].setYPos(wantY);
            currentBoard[wantX][wantY].setColor(currentBoard[pieceX][pieceY].getColor());
            currentBoard[pieceX][pieceY] = null;
        }
    }
}
