package com.compilerswork.solvers;

import com.compilerswork.constraints.ClassicConstraintsCalculator;
import com.compilerswork.constraints.ConstrainsCalculator;
import com.compilerswork.constraints.NoThreeQueensInLineConstraintsCalculator;
import com.compilerswork.printers.ConsolePrinter;
import com.compilerswork.utils.math.coordinates.CartesianCoordinatesConverter;
import org.junit.jupiter.api.Test;

public class IterativeQueensSolverTest {
    @Test
    void solve() {
        // Arrange
        var boardSize = 10;
        var queensNum = 10;
        var constrainsCalculator = new NoThreeQueensInLineConstraintsCalculator(new CartesianCoordinatesConverter());
//        var constrainsCalculator = new ClassicConstraintsCalculator(new CartesianCoordinatesConverter());
        QueensSolver solver = new IterativeQueensSolver(constrainsCalculator);

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
