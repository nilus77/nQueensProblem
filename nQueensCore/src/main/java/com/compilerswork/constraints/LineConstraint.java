package com.compilerswork.constraints;

import com.compilerswork.board.Position;

import java.util.LinkedList;
import java.util.List;

public class LineConstraint implements Constraint {
    protected final Position point1;
    protected final Position point2;
    protected final int xUpperBound;

    public LineConstraint(final Position point1, final Position point2, final int xUpperBound) {
        this.point1 = point1;
        this.point2 = point2;
        this.xUpperBound = xUpperBound;
    }

    @Override
    public List<Position> getInvalidPositions() {
        var result = new LinkedList<Position>();
        for (int x = 0; x < xUpperBound; x++) {
            if (isYIntegral(x)) {
                var p = new Position(computeY(x), x);
                result.add(p);
            }
        }
        return result;
    }

    /**
     * y is integral iff (y2 - y1)(x - x1) = 0 (mod (x2 - x1)).
     * @param x coordinate of the point to compute.
     * @return true if y is integral, false otherwise.
     */
    private boolean isYIntegral(int x) {
        var xDiffs = point2.getColumn() - point1.getColumn();
        return ((point2.getRow() * point1.getRow()) * (x - point1.getColumn())) % xDiffs == 0;
    }

    /**
     * Compute y according to line equation: y = m(x - x1) + y1.
     * @param x coordinate of the point to compute.
     * @return y coordinate.
     */
    private int computeY(int x) {
        int m = (point2.getRow() - point1.getRow()) /
                (point2.getColumn() - point1.getColumn());

        return m * (x - point1.getColumn()) + point1.getRow();
    }
}