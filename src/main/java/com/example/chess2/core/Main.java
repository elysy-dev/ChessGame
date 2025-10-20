package com.example.chess2.core;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        System.out.println("start");
        System.out.println("board[6][2] xLoc: "+ board.getBoard()[6][2].getXLoc());
        System.out.println("board[6][2] yLoc: "+ board.getBoard()[6][2].getYLoc());
        board.printBoardPretty();


        System.out.println("W: move 1");
        board.movePiece(1, 6, 1, 4);


        System.out.println("B: move 1");
        System.out.println("board[6][2] xLoc: "+ board.getBoard()[6][2].getXLoc());
        System.out.println("board[6][2] yLoc: "+ board.getBoard()[6][2].getYLoc());
        /*
        board.printBoardIndexed();
        board.movePiece(2, 6, 2, 4);
         */
    }
}
