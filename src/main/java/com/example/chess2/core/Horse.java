package com.example.chess2.core;

public class Horse extends Piece{
    public Horse(int xLoc, int yLoc, boolean isWhite) {
        super(xLoc, yLoc, isWhite);
    }

    @Override
    boolean moveIsLegal(Board board, int moveY, int moveX){
        //out of bounds
        if(!checkBounds(moveY, moveX)){
            return false;
        }

        int curYLoc = this.getXLoc();
        int curXLoc = this.getYLoc();

        //capturing own piece
        if(board.getBoard()[moveY][moveX] != null && board.getBoard()[moveY][moveX].isWhite() == this.isWhite()){
            return false;
        }
        //checking L
        if(Math.abs(curXLoc - moveX) == 2 && Math.abs(curYLoc - moveY) == 1 ||
                Math.abs(curYLoc - moveY) == 2 && Math.abs(curXLoc - moveX) == 1){
            return true;
        }
        return false;
    }
}
