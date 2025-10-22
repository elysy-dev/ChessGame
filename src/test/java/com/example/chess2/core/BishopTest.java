package com.example.chess2.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    private Board board;

    @Test
    void bishopTest() {
        board = new Board();

        assertTrue(board.movePiece(new int[]{3, 6, 3, 4}), "W: Pawn moves up");
        assertTrue(board.movePiece(new int[]{2, 6, 2, 4}), "B: Pawn moves up");
        assertTrue(board.movePiece(new int[]{2, 7, 4, 5}), "W: Bishop");
    }
}
