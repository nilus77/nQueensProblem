package com.compilerswork.solvers;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.SquareState;
import com.compilerswork.constraints.ConstrainsCalculator;
import com.compilerswork.constraints.Constraint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecursiveQueensSolver extends AbstractQueensSolver {
    private final ConstrainsCalculator constrainsCalculator;

    public RecursiveQueensSolver(ConstrainsCalculator constrainsCalculator) {
        this.constrainsCalculator = constrainsCalculator;
    }

    @Override
    public List<Solution> solve(int boardSize, int queensNum) {
        var solutions = new ArrayList<Solution>(boardSize);
        var board = new Chessboard(boardSize);

        doSolve(board, queensNum, new LinkedList<>(), solutions);

        return removeDuplicates(solutions);
    }

    private void doSolve(Chessboard board, int remainingQueens, List<Constraint> constraints, List<Solution> solutions) {
        if (remainingQueens == 0) {
            solutions.add(new Solution(new Chessboard(board)));
            return;
        }

        for (var square : board) {
            if (square.isFree()) {
                square.setState(SquareState.OCCUPIED);
                var newQueenPosition = square.getPosition();
                var newConstraints = constrainsCalculator.computeConstraints(board, newQueenPosition);
                constraints.addAll(newConstraints);
                applyConstrains(constraints, board);

                doSolve(board, remainingQueens - 1, constraints, solutions);

                square.setState(SquareState.FREE);
                constraints.removeAll(newConstraints);
                applyConstrains(constraints, board);
            }
        }
    }

    private void applyConstrains(List<Constraint> constraints, Chessboard board) {
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
