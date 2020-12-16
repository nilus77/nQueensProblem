package com.compilerswork.constraints;

import com.compilerswork.board.Chessboard;
import com.compilerswork.board.ChessboardUtils;
import com.compilerswork.board.Position;
import com.compilerswork.board.SquareState;
import com.compilerswork.utils.math.Line;
import com.compilerswork.utils.math.coordinates.CoordinatesConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueenMovementsConstraint extends AbstractConstraint {
    private final Position queenPosition;
    private final List<Line> movementLines;

    public QueenMovementsConstraint(CoordinatesConverter coordinatesConverter, Position queenPosition, int boardSize) {
        super(coordinatesConverter, boardSize);
        this.queenPosition = queenPosition;
        movementLines = new ArrayList<>(4);
        computeMovementLines();
    }

    @Override
    public List<Position> getInvalidPositions() {
        return movementLines
                .stream()
                .flatMap(l -> l.isAVerticalLine()
                        ? l.getIntegralPointsY(0, boardSize - 1).stream()
                        : l.getIntegralPoints(0, boardSize - 1).stream())
                .distinct()
                .map(coordinatesConverter::fromCartesianPoint)
                .filter(p -> ChessboardUtils.isPositionInsideBoard(p, boardSize))
                .filter(p -> !p.equals(queenPosition))
                .collect(Collectors.toList());
    }

    @Override
    public void apply(Chessboard board) {
        getInvalidPositions()
            .forEach(p -> board.setSquareState(p, SquareState.INVALID));
    }

    private void computeMovementLines() {
        var queenRow = queenPosition.getRow();
        var queenColumn = queenPosition.getColumn();

        // Vertical movements
        movementLines.add(new Line(coordinatesConverter.fromChessboardPosition(queenRow, queenColumn),
                                    coordinatesConverter.fromChessboardPosition(queenRow + 1, queenColumn)));

        // Horizontal movements
        movementLines.add(new Line(coordinatesConverter.fromChessboardPosition(queenRow, queenColumn),
                                    coordinatesConverter.fromChessboardPosition(queenRow, queenColumn + 1)));

        // Main diagonal movements
        var mainDiagSecondPoint = new Position(queenRow - 1, queenColumn - 1);
        movementLines.add(new Line(coordinatesConverter.fromChessboardPosition(queenPosition),
                                    coordinatesConverter.fromChessboardPosition(mainDiagSecondPoint)));

        // Secondary diagonal movements
        var secondaryDiagSecondPoint = new Position(queenRow - 1, queenColumn + 1);
        movementLines.add(new Line(coordinatesConverter.fromChessboardPosition(queenPosition),
                                    coordinatesConverter.fromChessboardPosition(secondaryDiagSecondPoint)));
    }
}