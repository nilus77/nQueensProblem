package com.compilerswork.solvers;

import com.compilerswork.constraints.ClassicConstraintsCalculator;
import com.compilerswork.constraints.ConstrainsCalculator;
import com.compilerswork.constraints.NoThreeQueensInLineConstraintsCalculator;
import com.compilerswork.printers.ConsolePrinter;
import com.compilerswork.utils.math.coordinates.CartesianCoordinatesConverter;
import org.junit.jupiter.api.Test;

public class RecursiveQueensSolverTest {
    @Test
    void solve() {
        // Arrange
        var boardSize = 8;
        var queensNum = 8;
        ConstrainsCalculator constrainsCalculator = new ClassicConstraintsCalculator(new CartesianCoordinatesConverter());
        QueensSolver solver = new RecursiveQueensSolver(constrainsCalculator);

        // Act
        var solutions = solver.solve(boardSize, queensNum);

        var printer = new ConsolePrinter();

        System.out.println("Solutions: " + solutions.size());
        for (var solution : solutions) {
            printer.print(solution.getBoard());
            System.out.println("");
            System.out.println("----");
        }
    }
}
