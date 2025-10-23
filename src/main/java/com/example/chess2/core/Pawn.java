package com.example.chess2.core;

public class Pawn extends Piece{
    public Pawn(int xLoc, int yLoc, boolean isWhite) {
        super(xLoc, yLoc, isWhite);
    }

    //TODO : fix error - pawns can't "touch"
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
            return true;
        }
        //move forward 2
        if (moveX == curXLoc && spacesUp == 2 &&
                board.getBoard()[moveY+1][moveX] == null && board.getBoard()[moveY][moveX] == null &&
                curYLoc == 6) {
            return true;
        }

        //capture
        if (Math.abs(moveX - curXLoc) == 1 && spacesUp == 1 &&
                board.getBoard()[moveY][moveX] != null && board.getBoard()[moveY][moveX].isWhite() != curColor) {
            return true;
        }

        return false;

        //TODO: when all other piece class made, add logic for switching pawn to other piece at end of board
    }
}
