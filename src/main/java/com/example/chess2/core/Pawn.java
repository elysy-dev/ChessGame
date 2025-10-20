package com.example.chess2.core;

public class Pawn extends Piece{
    public Pawn(int xLoc, int yLoc, boolean isWhite) {
        super(xLoc, yLoc, isWhite);
    }

    @Override
    boolean moveIsLegal(Board board, int moveY, int moveX){
        if(!checkBounds(moveY, moveX)){
            return false;
        }

        int curYLoc = this.getXLoc();
        int curXLoc = this.getYLoc();
        boolean curColor = this.isWhite();

        int spacesUp = curYLoc - moveY;

         //move forward 1
        if (moveX == curXLoc && spacesUp == 1 && board.getBoard()[moveY][moveX] == null) {
            System.out.println("forward 1");
            return true;
        }
        //move forward 2
        if (moveX == curXLoc && spacesUp == 2 &&
                board.getBoard()[moveY-1][moveX] == null && board.getBoard()[moveY][moveX] == null &&
                curYLoc == 6) {
            System.out.println("forward 2");
            return true;
        }

        //TODO: fix
        //capture
        if (Math.abs(moveX - curXLoc) == 1 && spacesUp == 1 &&
                board.getBoard()[moveY][moveX] != null && board.getBoard()[moveY][moveX].isWhite() != curColor) {
            System.out.println("capture");
            return true;
        }
        System.out.println("invalid white move");
        return false;
    }
}
