package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.ChessboardUtils;
import com.compilerswork.board.Position;
import com.compilerswork.board.SquareState;
import com.compilerswork.utils.math.Line;
import com.compilerswork.utils.math.coordinates.CoordinatesConverter;

import java.util.List;
import java.util.stream.Collectors;

public class QueensInLineConstraint extends AbstractConstraint {
    private final Position queen1Position;
    private final Position queen2Position;
    private final Line lineBetweenQueens;

    public QueensInLineConstraint(CoordinatesConverter coordinatesConverter, Position queen1Position, Position queen2Position, int boardSize) {
        super(coordinatesConverter, boardSize);
        this.queen1Position = queen1Position;
        this.queen2Position = queen2Position;
        lineBetweenQueens = new Line(coordinatesConverter.fromChessboardPosition(queen1Position),
                                        coordinatesConverter.fromChessboardPosition(queen2Position));
    }

    @Override
    public List<Position> getInvalidPositions() {
        return (lineBetweenQueens.isAVerticalLine()
                    ? lineBetweenQueens.getIntegralPointsY(0, boardSize - 1)
                    : lineBetweenQueens.getIntegralPoints(0, boardSize - 1))
                .stream()
                .distinct()
                .map(coordinatesConverter::fromCartesianPoint)
                .filter(p -> !(p.equals(queen1Position) || p.equals(queen2Position)))
                .filter(p -> ChessboardUtils.isPositionInsideBoard(p, boardSize))
                .collect(Collectors.toList());
    }

    @Override
    public void apply(Chessboard board) {
        getInvalidPositions()
                .forEach(p -> board.setSquareState(p, SquareState.INVALID));
    }
}
