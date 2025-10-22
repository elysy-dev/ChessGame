package com.example.chess2.core;

public class King extends Piece {
    public King(int xLoc, int yLoc, boolean isWhite) {
        super(xLoc, yLoc, isWhite);
    }

    @Override
    boolean moveIsLegal(Board board, int moveY, int moveX) {
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
        int xDiff = Math.abs(curXLoc - moveX), yDiff = Math.abs(curYLoc - moveY), totalDiff = xDiff + yDiff;
        if (xDiff <= 1 && yDiff <= 1 && (xDiff + yDiff) > 0 &&
                totalDiff > 0 && totalDiff <= 2) {
            return true;
        }
        return false;
    }
}
