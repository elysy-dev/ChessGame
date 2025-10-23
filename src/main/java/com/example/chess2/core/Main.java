package com.example.chess2.core;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();

        System.out.println();
        System.out.println("Starting Chess 2.0");
        board.printBoardPretty();
        int[] move;

        for (int i = 0; i < 200; i++) {
            move = UserInput.getPlayerMove();
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
