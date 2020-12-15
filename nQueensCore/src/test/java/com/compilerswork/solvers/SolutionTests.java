package com.compilerswork.solvers;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.board.SquareState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SolutionTests {
    @Test
    void equality() {
        // Arrange
        var b1 = new Chessboard(2);
        b1.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        b1.setSquareState(new Position(1, 1), SquareState.OCCUPIED);
        var b2 = new Chessboard(2);
        b2.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        b2.setSquareState(new Position(1, 1), SquareState.OCCUPIED);
        var s1 = new Solution(b1);
        var s2 = new Solution(b2);

        // Act
        var areEqual = s1.equals(s2);

        // Assert
        Assertions.assertTrue(areEqual);
    }

    @Test
    void removeDuplicateSolutions() {
        // Arrange
        var b1 = new Chessboard(2);
        b1.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        b1.setSquareState(new Position(1, 1), SquareState.OCCUPIED);
        var b2 = new Chessboard(2);
        b2.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        b2.setSquareState(new Position(1, 1), SquareState.OCCUPIED);
        var s1 = new Solution(b1);
        var s2 = new Solution(b2);
        var solutions = new ArrayList<Solution>(2);
        solutions.add(s1);
        solutions.add(s2);

        // Act
        var noDup = solutions.stream().distinct().collect(Collectors.toList());

        // Assert
        Assertions.assertEquals(1, noDup.size());
    }
}
