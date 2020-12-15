package com.compilerswork.utils.math.coordinates;

import com.compilerswork.board.Position;
import com.compilerswork.utils.math.Point;

public interface CoordinatesConverter {
    Point fromChessboardPosition(Position p);

    default Point fromChessboardPosition(int row, int column) {
        return fromChessboardPosition(new Position(row, column));
    }

    Position fromCartesianPoint(Point p);
}
