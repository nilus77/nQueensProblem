package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.printers.ConsolePrinter;
import com.compilerswork.utils.math.coordinates.CartesianCoordinatesConverter;
import org.junit.jupiter.api.Test;

public class QueenMovementsConstraintTests {
    @Test
    void applyConstraint() {
        // Arrange
        var boardSize = 4;
        var board = new Chessboard(boardSize);
        var queenPosition = new Position(0, 3);
        var constraint = new QueenMovementsConstraint(new CartesianCoordinatesConverter(), queenPosition, boardSize);

        // Act
        constraint.apply(board);

        // Assert
        new ConsolePrinter().print(board);
    }
}
