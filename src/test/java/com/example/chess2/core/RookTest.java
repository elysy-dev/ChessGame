package com.example.chess2.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private Board board;

    @Test
    void rookTest() {
        board = new Board();

        assertTrue(board.movePiece(new int[]{0, 6, 0, 4}));
        assertTrue(board.movePiece(new int[]{1, 7, 2, 5}));
        assertTrue(board.movePiece(new int[]{0, 7, 0, 5}));
        assertTrue(board.movePiece(new int[]{0, 6, 0, 4}));
        assertTrue(board.movePiece(new int[]{0, 5, 3, 5}));
    }
}
