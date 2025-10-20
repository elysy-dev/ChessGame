package com.example.chess2.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {

    private Board board;

    @Test
    void rookTest() {
        board = new Board();
        // start
        // (6,1) -> (4,1) : two-square first move
        assertTrue(board.movePiece(new int[]{1, 7, 2, 5}));
    }
}
