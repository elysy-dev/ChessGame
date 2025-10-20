package com.example.chess2.core;

public class Rook extends Piece{
    public Rook(int xLoc, int yLoc, boolean isWhite) {
        super(xLoc, yLoc, isWhite);
    }

    @Override
    boolean moveIsLegal(Board board, int moveX, int moveY) {
        if(!checkBounds(moveX, moveY)){
            return false;
        }
        int curXLoc = this.getXLoc();
        int curYLoc = this.getYLoc();
        boolean curColor = this.isWhite();

        //checks that move only chances exactly 1 of the x and y locations
        if((moveY == curYLoc && moveX == curXLoc) ||
                (moveY != curYLoc && moveX != curXLoc)){
            return false;
        }
        //move in X
        if(curXLoc != moveX){
            if(curXLoc < moveX) {
                for (curXLoc++; curXLoc < moveX; curXLoc++) {
                    if (board.getBoard()[curXLoc][curYLoc] != null) {
                        return false;
                    }
                }
            }
            else{
                for (curXLoc--; curXLoc > moveX; curXLoc--) {
                    if (board.getBoard()[curXLoc][curYLoc] != null) {
                        return false;
                    }
                }
            }
            if (board.getBoard()[curXLoc][curYLoc] != null && board.getBoard()[curXLoc][curYLoc].isWhite() == curColor) {
                return false;
            }
        }
        //move in Y
        if(curYLoc != moveY){
            if(curYLoc < moveY) {
                for (curYLoc++; curYLoc < moveY; curYLoc++) {
                    if (board.getBoard()[curXLoc][curYLoc] != null) {
                        return false;
                    }
                }
            }
            else{
                for (curYLoc--; curYLoc > moveY; curYLoc--) {
                    if (board.getBoard()[curXLoc][curYLoc] != null) {
                        return false;
                    }
                }
            }
            if (board.getBoard()[curXLoc][curYLoc] != null && board.getBoard()[curXLoc][curYLoc].isWhite() == curColor) {
                return false;
            }
        }
        return true;
    }

}
