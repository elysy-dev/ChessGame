package com.example.chess2.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    private Board board;

    @Test
    void queenTest() {
        board = new Board();

        assertTrue(board.movePiece(new int[]{3, 6, 3, 4}), "W: Pawn moves up");
        assertTrue(board.movePiece(new int[]{2, 6, 2, 4}), "B: Pawn moves up");
        assertTrue(board.movePiece(new int[]{3, 7, 3, 5}), "W: Queen forward");
        assertTrue(board.movePiece(new int[]{2, 4, 2, 3}), "B: Pawn moves up");
        assertTrue(board.movePiece(new int[]{3, 5, 2, 4}), "W: Queen diagonal");
    }
}
