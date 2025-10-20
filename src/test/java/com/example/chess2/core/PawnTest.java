package com.example.chess2.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;


    @Test
    void pawnAdvancesUntilBlocked() {
        board = new Board();
        // start
        // (1,1) -> (1,3) : two-square first move
        assertTrue(board.movePiece(1, 6, 1, 4), "First double move should be legal");

        // (1,3) -> (1,4)
        assertTrue(board.movePiece(1, 4, 1, 3), "Advance 1 should be legal");

        // (1,4) -> (1,5)
        assertTrue(board.movePiece(1, 3, 1, 2), "Advance 2 should be legal");

        // (1,5) -> (1,6) should be **blocked** by an opposing pawn on the starting rank
        assertTrue(!board.movePiece(1, 2, 1, 1), "Advance 3 should be legal");

        // (1,6) -> (1,7) should be **blocked** by an opposing pawn on the starting rank
        assertFalse(board.movePiece(1, 3, 2, 2), "Forward into occupied square must be illegal");
    }
}
