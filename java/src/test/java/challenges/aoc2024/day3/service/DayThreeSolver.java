package challenges.aoc2024.day3.service;

import java.util.List;

import service.DaySolver;
import util.AdventUtils;

public class DayThreeSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 3);
    private final ProgramService programService;

    public DayThreeSolver(ProgramService programService) {
        this.programService = programService;
    }

    @Override
    public String taskOne() {
        final String rawMemory = String.join("", inputLines);

        return String.valueOf(programService.calculateTotalOfMultiplicationInstructions(rawMemory, false));
    }

    @Override
    public String taskTwo() {
        final String rawMemory = String.join("", inputLines);

        return String.valueOf(programService.calculateTotalOfMultiplicationInstructions(rawMemory, true));
    }
}
