package other.collections;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.board.SquareState;
import com.compilerswork.solvers.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListTests {
    @Test
    void equalsSolutions() {
        // Arrange
        var b1 = new Chessboard(2);
        b1.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        var s1 = new ArrayList<Solution>();
        s1.add(new Solution(b1));

        var b2 = new Chessboard(2);
        b2.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        var s2 = new ArrayList<Solution>();
        s2.add(new Solution(b2));

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
        var b2 = new Chessboard(2);
        b2.setSquareState(new Position(0, 0), SquareState.OCCUPIED);
        var s = new ArrayList<Solution>();
        s.add(new Solution(b1));
        s.add(new Solution(b2));

        // Act
        var result = s.stream().distinct().collect(Collectors.toList());

        // Assert
        Assertions.assertEquals(1, result.size());
    }
}
