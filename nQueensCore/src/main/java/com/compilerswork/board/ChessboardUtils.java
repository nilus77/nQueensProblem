package com.compilerswork.board;

public final class ChessboardUtils {
    private ChessboardUtils() {

    }

    public static final boolean isPositionInsideBoard(Position p, int boardSize) {
        return p.getRow() >= 0 && p.getRow() < boardSize && p.getColumn() >= 0 && p.getColumn() < boardSize;
    }
}
