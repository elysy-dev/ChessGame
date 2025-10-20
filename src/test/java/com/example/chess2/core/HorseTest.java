package com.example.chess2.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    private Board board;

    @Test
    void horseTest() {
        board = new Board();

        assertTrue(board.movePiece(new int[]{1, 7, 2, 5}), "Horse move up");
    }
}
