package com.example.chess2.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;


    @Test
    void pawnAdvancesUntilBlocked() {
        board = new Board();
        // start
        // (6,1) -> (4,1) : two-square first move
        assertTrue(board.movePiece(new int[]{1, 6, 1, 4}), "W: First double move should be legal");

        // (6,1) -> (4,1)
        assertTrue(board.movePiece(new int[]{2, 6, 2, 4}), "B: First double move should be legal");

        // (1,4) -> (1,5)
        assertTrue(board.movePiece(new int[]{1, 4, 2, 3}), "W: move 2, capture paw");
        /*

        // (1,5) -> (1,6) should be **blocked** by an opposing pawn on the starting rank
        assertTrue(!board.movePiece(1, 2, 1, 1), "Advance 3 should be legal");

        // (1,6) -> (1,7) should be **blocked** by an opposing pawn on the starting rank
        assertFalse(board.movePiece(1, 3, 2, 2), "Forward into occupied square must be illegal");
         */
    }
}
