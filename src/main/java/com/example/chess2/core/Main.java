package com.example.chess2.core;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("start");
        //board.printBoardIndexed();
        board.printBoardPretty();
        board.movePiece(1, 6, 1, 4);
        System.out.println("move 1");
        //board.printBoardIndexed();
        board.printBoardPretty();
        board.movePiece(1, 4, 1, 3);
        System.out.println("move 2");
        //board.printBoardIndexed();
        board.printBoardPretty();
        board.movePiece(1, 3, 1, 2);
        System.out.println("move 3");
        //board.printBoardIndexed();
        board.printBoardPretty();
        board.movePiece(1, 2, 1, 1);
        System.out.println("move 4 - invalid because piece is in the way");
        //board.printBoardIndexed();
        board.printBoardPretty();
        board.movePiece(1, 1, 1, 2);
        System.out.println("move 5 - invalid because piece is in the way");
        //board.printBoardIndexed();
        board.printBoardPretty();
        board.movePiece(1, 2, 2, 1);
        System.out.println("move 6 - capture pawn");
        //board.printBoardIndexed();
        board.printBoardPretty();
    }
}
