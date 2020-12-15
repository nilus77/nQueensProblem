package com.compilerswork.solvers;

import com.compilerswork.board.Chessboard;

import java.util.Objects;

public class Solution {
    private final Chessboard board;

    public Solution(Chessboard board) {
        this.board = board;
    }

    public Chessboard getBoard() {
        return board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        var queensPosition1 = board.getQueensPositions();
        var queensPosition2 = solution.board.getQueensPositions();
        return queensPosition1.equals(queensPosition2);
    }

    @Override
    public int hashCode() {
        var queens = board.getQueensPositions();
        return queens.stream().map(Object::hashCode).reduce(0, (i, a) -> i + a);
    }
}
