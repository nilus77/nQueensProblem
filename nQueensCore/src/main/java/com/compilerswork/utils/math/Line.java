package com.compilerswork.utils.math;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private final Point p1;
    private final Point p2;
    private int m;

    public Line(final Point p1, final Point p2) {
        assert p1 != null;
        assert p2 != null;
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isAVerticalLine() {
        return p1.getX() == p2.getX();
    }

    public List<Point> getIntegralPointsY(final int y1, final int y2) {
        assert isAVerticalLine();
        assert y2 >= y1;
        var result = new LinkedList<Point>();
        var x = p1.getX();
        for (int y = y1; y <= y2; y++) {
            result.add(new Point(x, y));
        }
        return result;
    }

    public List<Point> getIntegralPoints(final int x1, final int x2) {
        assert x2 >= x1;
        var result = new LinkedList<Point>();
        for (int x = x1; x <= x2; x++) {
            if (isYIntegral(x)) {
                var y = getYAt(x);
                result.add(new Point(x, y));
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
        var xDiff = p2.getX() - p1.getX();
        return ((p2.getY() - p1.getY()) * (x - p1.getX())) % xDiff == 0;
    }

    /**
     * Compute y according to line equation: y = m(x - x1) + y1.
     * @param x coordinate of the point to compute.
     * @return y coordinate.
     */
    private int getYAt(int x) {
        return ((p2.getY() - p1.getY()) * (x - p1.getX())) / (p2.getX() - p1.getX()) + p1.getY();
    }
}