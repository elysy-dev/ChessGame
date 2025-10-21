package com.example.chess2.core;

public class Bishop extends Piece{
    public Bishop(int xLoc, int yLoc, boolean isWhite) {
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
        //checking diagonals
        //TODO : check if pieces in way of move
        if(Math.abs(moveY - curYLoc) == Math.abs(moveX - curXLoc)){
            return true;
        }
        return false;
    }
}
