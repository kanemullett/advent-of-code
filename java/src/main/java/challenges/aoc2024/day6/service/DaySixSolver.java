package challenges.aoc2024.day6.service;

import java.util.List;

import challenges.aoc2024.day6.model.LabMap;
import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 6 of the 2024 Advent of Code.
 */
public class DaySixSolver implements DaySolver {
    private final List<String> fileLines = AdventUtils.parseInput(2024, 6);
    private final LabService labService;
    
    /**
     * Solver class for the tasks of Day 6 of the 2024 Advent of Code.
     * 
     * @param labService The lab service used to simulate the lab guard's patrols.
     */
    public DaySixSolver(LabService labService) {
        this.labService = labService;
    }

    /**
     * Solve the first task of Day 6 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    @Override
    public String taskOne() {
        final LabMap labMap = LabMap.of(fileLines);

        return String.valueOf(labService.countNumberOfUniquePositionsGuardVisits(labMap));
    }

    /**
     * Solve the second task of Day 6 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    @Override
    public String taskTwo() {
        final LabMap labMap = LabMap.of(fileLines);

        return String.valueOf(labService.countObstructionPlacementPositions(labMap));
    }
}
