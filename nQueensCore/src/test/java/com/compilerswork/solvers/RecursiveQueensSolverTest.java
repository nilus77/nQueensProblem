package com.compilerswork.solvers;

import com.compilerswork.constraints.ConstrainsCalculator;
import com.compilerswork.constraints.NoThreeQueensInLineConstraintsCalculator;
import com.compilerswork.printers.ConsolePrinter;
import com.compilerswork.utils.math.coordinates.CartesianCoordinatesConverter;
import org.junit.jupiter.api.Test;

public class RecursiveQueensSolverTest {
    @Test
    void solve() {
        // Arrange
        var boardSize = 3;
        var queensNum = 2;
        ConstrainsCalculator constrainsCalculator = new NoThreeQueensInLineConstraintsCalculator(new CartesianCoordinatesConverter());
        QueensSolver solver = new RecursiveQueensSolver(constrainsCalculator);

        // Act
        var solutions = solver.solve(boardSize, queensNum);

        var printer = new ConsolePrinter();
        for (var solution : solutions) {
            printer.print(solution.getBoard());
            System.out.println("");
            System.out.println("----");
        }
    }
}
