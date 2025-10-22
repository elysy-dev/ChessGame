package com.example.chess2.core;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String WHITE_BG = "\u001B[47m";
    public static final String BLACK_BG = "\u001B[40m";
    public static final String WHITE_TEXT = "\u001B[37m";
    public static final String BLACK_TEXT = "\u001B[30m";
    public static void main(String[] args) {

        Board board = new Board();

        System.out.println("start");
        board.printBoardPretty();
        int[] move;

        for (int i = 0; i < 10; i++) {
            move = UserInput.getPlayerMove();
            board.movePiece(move);
            while(!board.movePiece(move)){
                board.flipBoard();
                move = UserInput.getPlayerMove();
                board.movePiece(move);
                board.flipBoard();
            }
            board.flipBoard();
        }
    }
}
