package com.example.chess2.core;

public class Main {
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
