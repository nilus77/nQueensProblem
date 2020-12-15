package com.compilerswork.solvers;

import com.compilerswork.board.Chessboard;

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
        return queensPosition1.containsAll(queensPosition2);
    }
}
