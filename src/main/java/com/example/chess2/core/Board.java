package com.example.chess2.core;

import java.util.Arrays;

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

    boolean movePiece(int[] move){
        int initialX = move[0], initialY = move[1], moveX = move[2], moveY = move[3];
        if(initialY > 7 || initialY < 0 || initialX > 7 || initialX < 0){
            return false;
        }
        if(this.board[initialY][initialX] != null && this.board[initialY][initialX].moveIsLegal(this, moveY, moveX)
            && this.board[initialY][initialX].isWhite() == whiteTurn){
            Piece p = this.board[initialY][initialX];
            this.board[initialY][initialX] = null;

            p.setXLoc(moveY);
            p.setYLoc(moveX);

            this.board[moveY][moveX] = p;
            this.whiteTurn = !this.whiteTurn;
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
                if(boardFlipped[i][j] != null) {
                    boardFlipped[i][j].setXLoc(i);
                    boardFlipped[i][j].setYLoc(j);
                }
            }
        }
        this.board = boardFlipped;
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
                else if(i == 7 && j == 1 || i == 7 && j == 6){
                    board[i][j] = new Horse(i, j, true);
                }
                else if(i == 0 && j == 1 || i == 0 && j == 6){
                    board[i][j] = new Horse(i, j, false);
                }
                else if(i == 7 && j == 2 || i == 7 && j == 5){
                    board[i][j] = new Bishop(i, j, true);
                }
                else if(i == 0 && j == 2 || i == 0 && j == 5){
                    board[i][j] = new Bishop(i, j, false);
                }
                else if(i == 0 && j == 3){
                    board[i][j] = new Queen(i, j, false);
                }
                else if(i == 7 && j == 3){
                    board[i][j] = new Queen(i, j, true);
                }
                else if(i == 0){
                    board[i][j] = new King(i, j, false);
                }
                else if(i == 7){
                    board[i][j] = new King(i, j, true);
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
                if(this.board[i][j] instanceof Bishop) {
                    if(this.board[i][j].isWhite()) {
                        System.out.print("+B: " + "(" + i + ", " + j + ") ");
                    }
                    else{
                        System.out.print("-B: " + "(" + i + ", " + j + ") ");
                    }
                }
                if(this.board[i][j] instanceof Queen) {
                    if(this.board[i][j].isWhite()) {
                        System.out.print("+Q: " + "(" + i + ", " + j + ") ");
                    }
                    else{
                        System.out.print("-Q: " + "(" + i + ", " + j + ") ");
                    }
                }
                if(this.board[i][j] instanceof King) {
                    if(this.board[i][j].isWhite()) {
                        System.out.print("+K: " + "(" + i + ", " + j + ") ");
                    }
                    else{
                        System.out.print("-K: " + "(" + i + ", " + j + ") ");
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

    public void printWhitePiece(String letter){
        System.out.print(ConsoleColors.PURPLE + " " + letter + " " + ConsoleColors.RESET);
    }
    public void printBlackPiece(String letter){
        System.out.print(ConsoleColors.CYAN_BRIGHT + ConsoleColors.BLACK + " " + letter + " " + ConsoleColors.RESET);
    }

    public void printBoardPretty(){
        System.out.println();
        for(int i = 0; i < Constants.BOARD_HEIGHT; i++){
            System.out.print("   ");
            for(int j = 0; j < Constants.BOARD_WIDTH; j++){
                if(j == 0){
                    System.out.print(ConsoleColors.RED);
                    System.out.print(8-i);
                    System.out.print(ConsoleColors.RESET);
                }
                if(this.board[i][j] instanceof Pawn) {
                    if(this.board[i][j].isWhite()) {
                        printWhitePiece("♙");
                    }
                    else{
                        printBlackPiece("♟");
                    }
                }
                if(this.board[i][j] instanceof Rook) {
                    if(this.board[i][j].isWhite()) {
                        printWhitePiece("♖");
                    }
                    else{
                        printBlackPiece("♜");
                    }
                }
                if(this.board[i][j] instanceof Horse) {
                    if(this.board[i][j].isWhite()) {
                        printWhitePiece("♘");
                    }
                    else{
                        printBlackPiece("♞");
                    }
                }
                if(this.board[i][j] instanceof Bishop) {
                    if(this.board[i][j].isWhite()) {
                        printWhitePiece("♗");
                    }
                    else{
                        printBlackPiece("♝");
                    }
                }
                if(this.board[i][j] instanceof Queen) {
                    if(this.board[i][j].isWhite()) {
                        printWhitePiece("♕");
                    }
                    else{
                        printBlackPiece("♛");
                    }
                }
                if(this.board[i][j] instanceof King) {
                    if(this.board[i][j].isWhite()) {
                        printWhitePiece("♔");
                    }
                    else{
                        printBlackPiece("♚");
                    }
                }
                if(this.board[i][j] == null){
                    if(i + j % 2 == 0){
                        printWhitePiece(" ");
                    }
                    else{
                        printBlackPiece(" ");
                    }
                }
            }
            System.out.println();
        }
        System.out.print(ConsoleColors.BLUE);
        System.out.println("     a   b  c   d  e   f   g  h ");
        System.out.println(ConsoleColors.RESET);
    }
}
