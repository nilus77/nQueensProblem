package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.Position;
import java.util.List;

public interface Constraint {
    List<Position> getInvalidPositions();

    void apply(Chessboard board);
}
