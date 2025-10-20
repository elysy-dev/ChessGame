package com.example.chess2.core;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("start");
        board.printBoardPretty();


        System.out.println("W: move 1");
        board.movePiece(1, 6, 1, 4);


        System.out.println("B: move 1");
        board.movePiece(2, 6, 2, 4);

        System.out.println("W: move 2, capture pawn");
        board.movePiece(1, 4, 2, 3);
    }
}
