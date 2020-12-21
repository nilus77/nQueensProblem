package com.compilerswork.solvers;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Square;
import com.compilerswork.board.SquareState;
import com.compilerswork.constraints.ConstrainsCalculator;
import com.compilerswork.constraints.Constraint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecursiveQueensSolver extends AbstractQueensSolver {
    public RecursiveQueensSolver(ConstrainsCalculator constrainsCalculator) {
        super(constrainsCalculator);
    }

    @Override
    public List<Solution> solve(int boardSize, int queensNum) {
        var solutions = new ArrayList<Solution>(boardSize);
        var board = new Chessboard(boardSize);

        doSolve(board, board.iterator(), queensNum, new LinkedList<>(), solutions);

        return solutions;
    }

    private void doSolve(Chessboard board, Iterator<Square> it, int remainingQueens, List<Constraint> constraints, List<Solution> solutions) {
        if (remainingQueens == 0) {
            solutions.add(new Solution(new Chessboard(board)));
            return;
        }

        while (it.hasNext()) {
            var square = it.next();
            if (square.isFree()) {
                square.setState(SquareState.OCCUPIED);
                var newQueenPosition = square.getPosition();
                var newConstraints = constrainsCalculator.computeConstraints(board, newQueenPosition);
                constraints.addAll(newConstraints);
                reapplyConstrains(constraints, board);

                doSolve(board, board.iterator(it), remainingQueens - 1, constraints, solutions);

                square.setState(SquareState.FREE);
                constraints.removeAll(newConstraints);
                reapplyConstrains(constraints, board);
            }
        }
    }
}
