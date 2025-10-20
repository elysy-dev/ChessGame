package com.example.chess2.core;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("start");
        board.printBoardPretty();
        int[] move = UserInput.getPlayerMove();

        System.out.println("W: move 1");
        board.movePiece(move);

        int[] move1 = UserInput.getPlayerMove();
        System.out.println("B: move 1");
        board.movePiece(move1);

        int[] move2 = UserInput.getPlayerMove();
        System.out.println("W: move 2, capture pawn");
        board.movePiece(move2);
    }
}
