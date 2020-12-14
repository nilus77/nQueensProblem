package com.compilerswork.printers;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.SquareState;
import org.junit.jupiter.api.Test;

public class ConsolePrinterTests {
    @Test
    void printBoard() {
        // Arrange
        var printer = new ConsolePrinter();
        var board = new Chessboard(5);

        int i = 0;
        for (var square : board) {
            if (i % 2 == 0) {
                square.setState(SquareState.INVALID);
            }
            i++;
        }

        // Act
        printer.print(board);
    }
}
