package com.compilerswork.board;


public class Square {
    private SquareState state;
    private final Position position;

    public Square(final int row, final int column) {
        this(SquareState.FREE, new Position(row, column));
    }

    public Square(final SquareState state, final Position position) {
        this.state = state;
        this.position = position;
    }

    public SquareState getState() {
        return state;
    }

    public void setState(SquareState state) {
        this.state = state;
    }

    public boolean isFree() {
        return state == SquareState.FREE;
    }

    public boolean isInvalid() {
        return state == SquareState.INVALID;
    }

    public boolean isOccupied() {
        return state == SquareState.OCCUPIED;
    }

    public Position getPosition() {
        return position;
    }
}
