package com.compilerswork.board;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Chessboard implements Iterable<Square> {
    private final int size;
    protected Square[][] board;

    public Chessboard(int size) {
        this.size = size;
        init();
    }

    public Chessboard(Chessboard board) {
        this(board.getSize());
        var it1 = iterator();
        var it2 = board.iterator();
        while (it1.hasNext()) {
            it1.next().setState(it2.next().getState());
        }
    }

    public void setSquareState(Position p, SquareState state) {
        assert ChessboardUtils.isPositionInsideBoard(p, size);
        board[p.getRow()][p.getColumn()].setState(state);
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Square> iterator() {
        return new ChessboardIterator(board);
    }

    public Iterator<Square> iterator(Iterator<Square> it) {
        return new ChessboardIterator(board, (ChessboardIterator)it);
    }

    public List<Position> getQueensPositions() {
        var positions = new LinkedList<Position>();
        for (var square : this) {
            if (square.isOccupied()) {
                positions.add(square.getPosition());
            }
        }
        return positions;
    }

    private void init() {
        board = new Square[size][size];
        for (int i = 0; i < size; i++) {
            board[i] = new Square[size];
            for (int j = 0; j < size; j++) {
                board[i][j] = new Square(i, j);
            }
        }
    }
}
