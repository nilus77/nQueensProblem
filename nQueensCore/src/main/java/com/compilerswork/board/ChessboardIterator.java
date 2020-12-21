package com.compilerswork.board;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChessboardIterator implements Iterator<Square> {
    private final Square[][] board;
    private final int size;
    private int i;
    private int j;

    public ChessboardIterator(Square[][] board) {
        this.size = board.length;
        this.board = board;
        i = j = 0;
    }

    public ChessboardIterator(Square[][] board, ChessboardIterator it) {
        this.size = board.length;
        this.board = board;
        i = it.i;
        j = it.j;
    }

    @Override
    public boolean hasNext() {
        return i < size && j < size;
    }

    @Override
    public Square next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        var square = board[i][j];
        j++;
        if (j == size) {
            j = 0;
            i++;
        }
        return square;
    }
}
