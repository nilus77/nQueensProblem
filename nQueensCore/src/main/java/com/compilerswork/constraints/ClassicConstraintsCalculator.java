package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.utils.math.coordinates.CoordinatesConverter;
import java.util.List;

public class ClassicConstraintsCalculator extends AbstractConstraintsCalculator {
    protected ClassicConstraintsCalculator(CoordinatesConverter coordinatesConverter) {
        super(coordinatesConverter);
    }

    @Override
    public List<Constraint> computeConstraints(Chessboard board, Position queenPosition) {
        return List.of(new QueenMovementsConstraint(coordinatesConverter, queenPosition, board.getSize()));
    }
}
