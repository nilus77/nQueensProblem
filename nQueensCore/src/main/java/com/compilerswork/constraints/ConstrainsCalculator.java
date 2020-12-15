package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;

import java.util.List;

public interface ConstrainsCalculator {
    List<Constraint> computeConstraints(Chessboard board, Position queenPosition);
}
