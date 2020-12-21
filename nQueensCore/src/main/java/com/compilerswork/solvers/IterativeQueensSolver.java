package com.compilerswork.solvers;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.ChessboardIterator;
import com.compilerswork.board.Square;
import com.compilerswork.board.SquareState;
import com.compilerswork.constraints.ConstrainsCalculator;
import com.compilerswork.constraints.Constraint;

import java.util.*;

public class IterativeQueensSolver extends AbstractQueensSolver {
    private class Configuration {
        public Chessboard board;
        public Iterator<Square> it;
        public int remainingQueens;
        public List<Constraint> constraints;
    }

    private Stack<Configuration> configurations;
    private List<Solution> solutions;

    public IterativeQueensSolver(ConstrainsCalculator constrainsCalculator) {
        super(constrainsCalculator);
    }

    @Override
    public List<Solution> solve(int boardSize, int queensNum) {
        solutions = new ArrayList<>(boardSize);
        configurations = new Stack<>();

        var firstConfig = new Configuration();
        firstConfig.board = new Chessboard(boardSize);
        firstConfig.it = firstConfig.board.iterator();
        firstConfig.remainingQueens = queensNum;
        firstConfig.constraints = new LinkedList<>();
        configurations.push(firstConfig);

        while (!configurations.empty()) {
            var config = configurations.pop();
            solveConfiguration(config);
        }

//        return removeDuplicates(solutions);
        return solutions;
    }

    private void solveConfiguration(Configuration config) {
        var it = config.it;
        var nextConfigAvailable = false;
        while (it.hasNext() && !nextConfigAvailable) {
            var square = it.next();
            if (square.isFree()) {
                var newQueenPosition = square.getPosition();
                var newConfig = new Configuration();
                newConfig.board = new Chessboard(config.board);
                newConfig.it = newConfig.board.iterator(config.it);
                newConfig.constraints = new LinkedList<>(config.constraints);
                var newConstraints = constrainsCalculator.computeConstraints(newConfig.board, newQueenPosition);
                newConfig.constraints.addAll(newConstraints);
                newConfig.remainingQueens = config.remainingQueens - 1;

                newConfig.board.setSquareState(newQueenPosition, SquareState.OCCUPIED);
                reapplyConstrains(newConfig.constraints, newConfig.board);

                if (newConfig.remainingQueens == 0) {
                    solutions.add(new Solution(new Chessboard(newConfig.board)));
                }
                else {
                    configurations.push(config);
                    configurations.push(newConfig);
                    nextConfigAvailable = true;
                }
            }
        }
    }
}
