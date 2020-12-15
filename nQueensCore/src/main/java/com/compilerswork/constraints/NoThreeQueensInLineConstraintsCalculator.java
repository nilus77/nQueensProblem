package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import com.compilerswork.utils.math.coordinates.CoordinatesConverter;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class NoThreeQueensInLineConstraintsCalculator extends ClassicConstraintsCalculator {
    private class PositionPair {
        public Position p1;
        public Position p2;

        public PositionPair(Position p1, Position p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PositionPair that = (PositionPair) o;
            return Objects.equals(p1, that.p1) && Objects.equals(p2, that.p2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }
    }

    public NoThreeQueensInLineConstraintsCalculator(CoordinatesConverter coordinatesConverter) {
        super(coordinatesConverter);
    }

    @Override
    public List<Constraint> computeConstraints(Chessboard board, Position queenPosition) {
        var classicConstrains = super.computeConstraints(board, queenPosition);
        List<Constraint> constraints = new LinkedList<>();
        var queensPositions = board.getQueensPositions();

//        queensPositions
//                .stream()
//                .flatMap(p1 -> queensPositions.stream().map(p2 -> new PositionPair(p1, p2)))
//                .filter(pp -> !pp.p1.equals(pp.p2))
//                .distinct();

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
