package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.printers.ConsolePrinter;
import com.compilerswork.utils.math.coordinates.CartesianCoordinatesConverter;
import org.junit.jupiter.api.Test;

public class QueensInLineConstraintTests {
    @Test
    void applyConstraints() {
        // Arrange
        var boardSize = 8;
        var board = new Chessboard(boardSize);
        var q1 = new Position(0, 0);
        var q2 = new Position(1, 2);
        var constraint = new QueensInLineConstraint(new CartesianCoordinatesConverter(), q1, q2, boardSize);

        // Act
        constraint.apply(board);

        // Assert
        new ConsolePrinter().print(board);
    }
}
