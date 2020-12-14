package com.compilerswork.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChessboardTests {
    @Test
    void MakeNewChessboard() {
        // Act
        var board = new Chessboard(5);
        // Assert
        Assertions.assertNotNull(board);
    }
}
