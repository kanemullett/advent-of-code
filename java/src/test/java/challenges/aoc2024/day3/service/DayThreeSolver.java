package challenges.aoc2024.day3.service;

import java.util.List;

import challenges.aoc2024.day3.model.ComputerMemory;
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
        
        return String.valueOf(inputLines.stream()
            .map(ComputerMemory::of)
            .map(memory -> programService.calculateTotalOfMultiplicationInstructions(memory))
            .mapToInt(Integer::intValue)
            .sum());
    }

    @Override
    public String taskTwo() {
        return null;
    }
}
