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
        if(Math.abs(moveY - curYLoc) == Math.abs(moveX - curXLoc)) {
            return true;
        }
        //checking diagonals
        //TODO : check if pieces in way of move
//        if(Math.abs(moveY - curYLoc) == Math.abs(moveX - curXLoc)){
//            //piece is left and higher than target
//            if(curXLoc < moveX && curYLoc < moveY){
//                for(curXLoc++, curYLoc++; curXLoc != moveX; curXLoc++, curYLoc++){
//                    if(board.getBoard()[curYLoc][curXLoc] != null){
//                        return false;
//                    }
//                }
//            }
//            //piece is right and higher than target
//            else if(curXLoc > moveX && curYLoc < moveY){
//                for(curXLoc--, curYLoc++; curXLoc != moveX; curXLoc--, curYLoc++){
//                    if(board.getBoard()[curYLoc][curXLoc] != null){
//                        return false;
//                    }
//                }
//            }
//            //piece is right and lower than target
//            else if(curXLoc > moveX && curYLoc > moveY){
//                for(curXLoc--, curYLoc--; curXLoc != moveX; curXLoc--, curYLoc--){
//                    if(board.getBoard()[curYLoc][curXLoc] != null){
//                        return false;
//                    }
//                }
//            }
//            //piece is left and lower than target
//            else if(curXLoc < moveX && curYLoc > moveY){
//                for(curXLoc++, curYLoc--; curXLoc != moveX; curXLoc++, curYLoc--){
//                    if(board.getBoard()[curYLoc][curXLoc] != null){
//                        return false;
//                    }
//                }
//            }
//            else{
//                return false;
//            }
//            //double checks y "follows" x
//            if(board.getBoard()[curYLoc][curXLoc] != board.getBoard()[moveY][moveX]){
//                return false;
//            }
//            //capturing own piece
//            if(board.getBoard()[moveY][moveX] != null && board.getBoard()[moveY][moveX].isWhite() == this.isWhite()){
//                return false;
//            }
//        }
        return false;
    }
}
