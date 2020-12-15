package com.compilerswork.solvers;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractQueensSolver implements QueensSolver {
    protected List<Solution> removeDuplicates(List<Solution> solutions) {
        return solutions.stream().distinct().collect(Collectors.toList());
    }
}
