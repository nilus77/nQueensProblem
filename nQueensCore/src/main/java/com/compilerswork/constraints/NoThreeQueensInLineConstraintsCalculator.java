package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.utils.math.coordinates.CoordinatesConverter;

import java.util.LinkedList;
import java.util.List;

public class NoThreeQueensInLineConstraintsCalculator extends ClassicConstraintsCalculator {
    public NoThreeQueensInLineConstraintsCalculator(CoordinatesConverter coordinatesConverter) {
        super(coordinatesConverter);
    }

    @Override
    public List<Constraint> computeConstraints(Chessboard board, Position queenPosition) {
        var classicConstrains = super.computeConstraints(board, queenPosition);
        List<Constraint> constraints = new LinkedList<>();
        var queensPositions = board.getQueensPositions();

        for (var p1 : queensPositions) {
            for (var p2 : queensPositions) {
                if (!p1.equals(p2)) {
                    var constraint = new QueensInLineConstraint(coordinatesConverter, p1, p2, board.getSize());
                    constraints.add(constraint);
                }
            }
        }

        constraints.addAll(classicConstrains);
        return constraints;
    }
}
