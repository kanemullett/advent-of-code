package challenges.aoc2024.day3.service;

import java.util.List;

import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 3 of the 2024 Advent of Code.
 */
public class DayThreeSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 3);
    private final ProgramService programService;

    /**
     * Solver class for the tasks of Day 3 of the 2024 Advent of Code.
     * 
     * @param programService The program service used to extract information from corrupted data.
     */
    public DayThreeSolver(ProgramService programService) {
        this.programService = programService;
    }

    /**
     * Solve the first task of Day 3 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    @Override
    public String taskOne() {
        final String rawMemory = String.join("", inputLines);

        return String.valueOf(programService.calculateTotalOfMultiplicationInstructions(rawMemory, false));
    }

    /**
     * Solve the second task of Day 3 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    @Override
    public String taskTwo() {
        final String rawMemory = String.join("", inputLines);

        return String.valueOf(programService.calculateTotalOfMultiplicationInstructions(rawMemory, true));
    }
}
