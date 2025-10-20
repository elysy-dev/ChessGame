package com.example.chess2.core;

public class Board {
    private Piece[][] board;
    private boolean whiteTurn;

    public Board() {
        this.board = initBoard();
        this.whiteTurn = true;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public boolean whiteTurn() {
        return this.whiteTurn;
    }

    public void setWhiteTurn(boolean whiteTurn) {
        this.whiteTurn = whiteTurn;
    }

    void printMovedBoardAndFlipped(){
        System.out.println("after move, pre flip");
        printBoardPretty();
        System.out.println("after move, post flip");
        flipBoard();
        printBoardPretty();
    }

    boolean movePiece(int initialX, int initialY, int moveX, int moveY){
        if(this.board[initialY][initialX] != null && this.board[initialY][initialX].moveIsLegal(this, moveY, moveX)
            && this.board[initialY][initialX].isWhite() == whiteTurn){
            Piece p = this.board[initialY][initialX];
            this.board[initialY][initialX] = null;

            p.setXLoc(moveY);
            p.setYLoc(moveX);

            this.board[moveY][moveX] = p;
            this.whiteTurn = false;
            printMovedBoardAndFlipped();
            return true;
        }
        else{
            return false;
        }
    }

    void flipBoard(){
        Piece[][] boardFlipped = new Piece[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
        for(int i = 0; i < Constants.BOARD_HEIGHT; i++){
            for(int j = 0; j < Constants.BOARD_WIDTH; j++){
                boardFlipped[i][j] = this.board[7-i][j];
            }
        }
        //this.board = boardFlipped;
        for(int i = 0; i < Constants.BOARD_HEIGHT; i++){
            for(int j = 0; j < Constants.BOARD_WIDTH; j++){
                this.board[i][j] = boardFlipped[i][j];
            }
        }
    }

    public Piece[][] initBoard(){
        Piece[][] board = new Piece[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
        for(int i = 0; i < Constants.BOARD_HEIGHT; i++){
            for(int j = 0; j < Constants.BOARD_WIDTH; j++){
                if(i == 1){
                    board[i][j] = new Pawn(i, j, false);
                }
                else if(i == Constants.BOARD_HEIGHT - 2){
                    board[i][j] = new Pawn(i, j, true);
                }
                else if(i == 0 && j == 0 || i == 0 && j == 7){
                    board[i][j] = new Rook(i, j, false);
                }
                else if(i == 7 && j == 0 || i == 7 && j == 7){
                    board[i][j] = new Rook(i, j, true);
                }
                else {
                    board[i][j] = null;
                }
            }
        }
        //TODO: implement logic for non pawn characters
        return board;
    }

    public void printBoardIndexed(){
        for(int i = 0; i < Constants.BOARD_HEIGHT; i++){
            for(int j = 0; j < Constants.BOARD_WIDTH; j++){
                if(this.board[i][j] instanceof Pawn) {
                    if(this.board[i][j].isWhite()) {
                        System.out.print("+P: " + "(" + i + ", " + j + ") ");
                    }
                    else{
                        System.out.print("-P: " + "(" + i + ", " + j + ") ");
                    }
                }
                if(this.board[i][j] instanceof Rook) {
                    if(this.board[i][j].isWhite()) {
                        System.out.print("+R: " + "(" + i + ", " + j + ") ");
                    }
                    else{
                        System.out.print("-R: " + "(" + i + ", " + j + ") ");
                    }
                }
                if(this.board[i][j] == null){
                    System.out.print("X: " + "(" + i + ", " + j + ") ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printBoardPretty(){
        for(int i = 0; i < Constants.BOARD_HEIGHT; i++){
            for(int j = 0; j < Constants.BOARD_WIDTH; j++){
                if(this.board[i][j] instanceof Pawn) {
                    if(this.board[i][j].isWhite()) {
                        System.out.print(" +P");
                    }
                    else{
                        System.out.print(" -P");
                    }
                }
                if(this.board[i][j] instanceof Rook) {
                    if(this.board[i][j].isWhite()) {
                        System.out.print(" +R");
                    }
                    else{
                        System.out.print(" -R");
                    }
                }
                if(this.board[i][j] == null){
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
