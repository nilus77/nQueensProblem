package com.compilerswork.board;

import java.util.Iterator;

public class Chessboard implements Cloneable, Iterable<Square> {
    private final int size;
    private Square[][] board;

    public Chessboard(int size) {
        this.size = size;
        init();
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        var clone = new Chessboard(size);
        var it = iterator();
        var cloneIt = clone.iterator();
        while (it.hasNext()) {
            cloneIt.next().setState(it.next().getState());
        }
        return clone;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Square> iterator() {
        return new ChessboardIterator(size, board);
    }
}
