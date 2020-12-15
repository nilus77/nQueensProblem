package com.compilerswork.utils.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTests {
    @Test
    void pointsOnHorizontalLine() {
        // Arrange
        var l = new Line(new Point(2, 1), new Point(3, 1));

        // Act
        var points = l.getIntegralPoints(1, 3);

        // Assert
        Point[] result = {
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 1)
        };
        Assertions.assertArrayEquals(result, points.toArray());
    }

    @Test
    void pointsOnVerticalLine() {
        // Arrange
        var l = new Line(new Point(1, 1), new Point(1, 2));

        // Act
        var points = l.getIntegralPointsY(1, 3);

        // Assert
        Point[] result = {
                new Point(1, 1),
                new Point(1, 2),
                new Point(1, 3)
        };
        Assertions.assertArrayEquals(result, points.toArray());
    }

    @Test
    void pointsOnGenericLine() {
        // Arrange
        var l = new Line(new Point(1, 1), new Point(2, 0));

        // Act
        var points = l.getIntegralPoints(0, 3);

        // Assert
        Point[] result = {
                new Point(0, 2),
                new Point(1, 1),
                new Point(2, 0),
                new Point(3, -1),
        };
        Assertions.assertArrayEquals(result, points.toArray());
    }
}
