package com.example.chess2.core;

public class Queen extends Rook{
    public Queen(int xLoc, int yLoc, boolean isWhite) {
        super(xLoc, yLoc, isWhite);
    }

    @Override
    boolean moveIsLegal(Board board, int moveX, int moveY) {
        //out of bounds
        if (!checkBounds(moveY, moveX)) {
            return false;
        }

        int curYLoc = this.getXLoc();
        int curXLoc = this.getYLoc();

        //capturing own piece
        if (board.getBoard()[moveY][moveX] != null && board.getBoard()[moveY][moveX].isWhite() == this.isWhite()) {
            return false;
        }
        //bishop
        if (Math.abs(moveY - curYLoc) == Math.abs(moveX - curXLoc)) {
            return true;
        }
        //calls Rook move logic
        if(super.moveIsLegal(board, moveX, moveY)){
            return true;
        }
        return false;
    }
}
