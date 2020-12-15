package com.compilerswork.constraints;

import com.compilerswork.utils.math.coordinates.CoordinatesConverter;

public abstract class AbstractConstraint implements Constraint {
    protected final CoordinatesConverter coordinatesConverter;
    protected final int boardSize;

    protected AbstractConstraint(CoordinatesConverter coordinatesConverter, int boardSize) {
        this.coordinatesConverter = coordinatesConverter;
        this.boardSize = boardSize;
    }
}
