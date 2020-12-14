package com.compilerswork.printers;

import com.compilerswork.board.Chessboard;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Chessboard board) {
        var size = board.getSize();
        int i = 0;
        for (var square : board) {
            if (i == size) {
                System.out.println();
                i = 0;
            }
            switch (square.getState()) {
                case FREE -> System.out.print("_");
                case OCCUPIED -> System.out.print("*");
                case INVALID -> System.out.print("X");
            }
            System.out.print(" ");
            i++;
        }
    }
}
