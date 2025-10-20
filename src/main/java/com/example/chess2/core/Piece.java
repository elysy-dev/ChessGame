package com.example.chess2.core;

public abstract class Piece {
    private int xLoc;
    private int yLoc;
    private boolean isWhite;

    public Piece(int xLoc, int yLoc, boolean isWhite) {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.isWhite = isWhite;
    }

    public int getXLoc() {
        return xLoc;
    }

    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    /**
     * Checks if move is valid.
     *
     * <p>Sees if move follows the rules of the specific piece.</p>
     *
     * @param
     * @return true if valid move, false if invalid
     */

    abstract boolean moveIsLegal(Board board, int moveY, int moveX);

    public boolean checkBounds(int moveX, int moveY){
        //checks y
        if(moveY > Constants.BOARD_HEIGHT-1 || moveY < 0){
            System.out.println("Moving Y off board.");
            return false;
        }
        //checks x
        if(moveX > Constants.BOARD_HEIGHT-1 || moveX < 0){
            System.out.println("Moving X off board.");
            return false;
        }
        return true;
    }
}
