package com.compilerswork.printers;

import com.compilerswork.board.Chessboard;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Chessboard board) {
        var sb = new StringBuilder();
        var size = board.getSize();
        int i = 0;
        for (var square : board) {
            if (i == size) {
                sb.append("\n");
                i = 0;
            }
            switch (square.getState()) {
                case FREE -> sb.append("_");
                case OCCUPIED -> sb.append("*");
                case INVALID -> sb.append("X");
            }
            sb.append(" ");
            i++;
        }
        System.out.print(sb.toString());
    }
}
