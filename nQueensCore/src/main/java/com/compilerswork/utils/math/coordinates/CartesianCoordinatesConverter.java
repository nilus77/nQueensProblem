package com.compilerswork.utils.math.coordinates;

import com.compilerswork.board.Position;
import com.compilerswork.utils.math.Point;

public class CartesianCoordinatesConverter implements CoordinatesConverter {
    @Override
    public Point fromChessboardPosition(Position p) {
        return new Point(p.getColumn(), p.getRow());
    }

    @Override
    public Position fromCartesianPoint(Point p) {
        return new Position(p.getY(), p.getX());
    }
}
