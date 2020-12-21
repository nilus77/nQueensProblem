package com.compilerswork.solvers;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.SquareState;
import com.compilerswork.constraints.ConstrainsCalculator;
import com.compilerswork.constraints.Constraint;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractQueensSolver implements QueensSolver {
    protected final ConstrainsCalculator constrainsCalculator;

    protected AbstractQueensSolver(ConstrainsCalculator constrainsCalculator) {
        this.constrainsCalculator = constrainsCalculator;
    }

    protected List<Solution> removeDuplicates(List<Solution> solutions) {
        return solutions.stream().distinct().collect(Collectors.toList());
    }

    protected void reapplyConstrains(List<Constraint> constraints, Chessboard board) {
        for (var square : board) {
            if (square.isInvalid()) {
                square.setState(SquareState.FREE);
            }
        }

        for (var constraint : constraints) {
            constraint.apply(board);
        }
    }
}
