import java.util.Scanner;

import game.ChessGame;
import pieces.enums.Color;
import pieces.enums.Type;

import static game.ChessGame.currentBoard;

public class ChessGameDriver {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 3;
    private static final int E = 4;
    private static final int F = 5;
    private static final int G = 6;
    private static final int H = 7;

    public static void main(String[] args) {
        ChessGame chessGame = ChessGame.getInstance();
        chessGame.populateBoard();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("""
                R  Kn  B  Q  K  B  Kn  R
                P  P   P  P  P  P  P   P
                
                
                
                
                P  P   P  P  P  P  P   P
                R  Kn  B  Q  K  B  Kn  R""");
        System.out.println("Select a piece (ex. E1  for White King)");
        String choice = keyboard.nextLine();
        while (!Character.isLetter(choice.charAt(0)) || !Character.isDigit(choice.charAt(1))) {
            System.out.println("Please enter a valid input (ex. E1 for White King)");
            keyboard.nextLine();
            choice = keyboard.nextLine();
        }
        int originalColumn;
        int originalRow;
        switch (choice.charAt(0)) {
            case 'A' -> originalColumn = A;
            case 'B' -> originalColumn = B;
            case 'C' -> originalColumn = C;
            case 'D' -> originalColumn = D;
            case 'E' -> originalColumn = E;
            case 'F' -> originalColumn = F;
            case 'G' -> originalColumn = G;
            case 'H' -> originalColumn = H;
            default -> originalColumn = 0;
        }
        // numbers don't match due to top of array being 0 while top of board is 8 (from white pov)
        switch (Integer.parseInt(choice.substring(1))) {
            case 1 -> originalRow = 7;
            case 2 -> originalRow = 6;
            case 3 -> originalRow = 5;
            case 4 -> originalRow = 4;
            case 5 -> originalRow = 3;
            case 6 -> originalRow = 2;
            case 7 -> originalRow = 1;
            case 8 -> originalRow = 0;
            default -> originalRow = 0;
        }
        System.out.println("You chose " + choice + " which is the " + currentBoard[originalColumn][originalRow].getColor() + " " + currentBoard[originalColumn][originalRow].getType() + ".");

        System.out.println("Please choose a destination: ");
        String destination = keyboard.nextLine();
        while (!Character.isLetter(destination.charAt(0)) || !Character.isDigit(destination.charAt(1))) {
            System.out.println("Please enter a valid input (ex. E1 for White King)");
            keyboard.nextLine();
            destination = keyboard.nextLine();
        }

        int desiredColumn;
        int desiredRow;
        switch (destination.charAt(0)) {
            case 'A' -> desiredColumn = A;
            case 'B' -> desiredColumn = B;
            case 'C' -> desiredColumn = C;
            case 'D' -> desiredColumn = D;
            case 'E' -> desiredColumn = E;
            case 'F' -> desiredColumn = F;
            case 'G' -> desiredColumn = G;
            case 'H' -> desiredColumn = H;
            default -> desiredColumn = 0;
        }
        switch (Integer.parseInt(destination.substring(1))) {
            case 1 -> desiredRow = 7;
            case 2 -> desiredRow = 6;
            case 3 -> desiredRow = 5;
            case 4 -> desiredRow = 4;
            case 5 -> desiredRow = 3;
            case 6 -> desiredRow = 2;
            case 7 -> desiredRow = 1;
            case 8 -> desiredRow = 0;
            default -> desiredRow = 0;
        }
        if (currentBoard[originalColumn][originalRow].isValid(desiredColumn, desiredRow)) {
            System.out.println("Valid move.");
        }

        Type originalType = currentBoard[originalColumn][originalRow].getType();
        Color originalColor = currentBoard[originalColumn][originalRow].getColor();
        chessGame.movePiece(originalColumn, originalRow, desiredColumn, desiredRow);
        if (currentBoard[desiredColumn][desiredRow].getType() == originalType) {
            System.out.println("Your " + originalColor + " " + originalType + " has moved to " + destination);
        }
        else System.out.println("Failed.");
    }
}
