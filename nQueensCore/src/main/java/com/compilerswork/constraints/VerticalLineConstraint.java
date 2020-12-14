package com.compilerswork.constraints;

import com.compilerswork.board.Position;

import java.util.LinkedList;
import java.util.List;

public class VerticalLineConstraint extends LineConstraint {
    public VerticalLineConstraint(Position point1, int xUpperBound) {
        super(point1, point1, xUpperBound);
    }

    @Override
    public List<Position> getInvalidPositions() {
        var result = new LinkedList<Position>();
        for (int i = 0; i < xUpperBound; i++) {
            var p = new Position(i, point1.getColumn());
            result.add(p);
        }
        return result;
    }
}
