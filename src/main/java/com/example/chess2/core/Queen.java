package com.example.chess2.core;

public class Queen extends Piece{
    public Queen(int xLoc, int yLoc, boolean isWhite) {
        super(xLoc, yLoc, isWhite);
    }

    @Override
    boolean moveIsLegal(Board board, int moveX, int moveY) {
        //out of bounds
        if(!checkBounds(moveY, moveX)){
            return false;
        }

        int curYLoc = this.getXLoc();
        int curXLoc = this.getYLoc();
        boolean curColor = this.isWhite();

        //capturing own piece
        if(board.getBoard()[moveY][moveX] != null && board.getBoard()[moveY][moveX].isWhite() == this.isWhite()){
            return false;
        }
        //bishop
        if(Math.abs(moveY - curYLoc) == Math.abs(moveX - curXLoc)) {
            return true;
        }
        //rook
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
