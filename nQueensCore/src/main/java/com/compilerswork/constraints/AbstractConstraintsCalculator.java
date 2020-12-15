package com.compilerswork.constraints;

import com.compilerswork.utils.math.coordinates.CoordinatesConverter;

public abstract class AbstractConstraintsCalculator implements ConstrainsCalculator {
    protected final CoordinatesConverter coordinatesConverter;

    protected AbstractConstraintsCalculator(CoordinatesConverter coordinatesConverter) {
        this.coordinatesConverter = coordinatesConverter;
    }
}
