package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.board.SquareState;
import com.compilerswork.utils.math.coordinates.CartesianCoordinatesConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoThreeQueensInLineConstraintsCalculatorTests {
    @Test
    void noDuplicates() {
        // Arrange
        var board = new Chessboard(3);
        board.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        board.setSquareState(new Position(1, 1), SquareState.OCCUPIED);
        var constraintsCalculator = new NoThreeQueensInLineConstraintsCalculator(new CartesianCoordinatesConverter());

        // Act
        var constraints = constraintsCalculator.computeConstraints(board, new Position(1, 1));

        // Assert
        Assertions.assertEquals(2, constraints.size());
    }
}
