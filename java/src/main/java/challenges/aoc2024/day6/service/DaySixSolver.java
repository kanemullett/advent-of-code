package challenges.aoc2024.day6.service;

import java.util.List;

import challenges.aoc2024.day6.model.LabMap;
import service.DaySolver;
import util.AdventUtils;

public class DaySixSolver implements DaySolver {
    private final List<String> fileLines = AdventUtils.parseInput(2024, 6);
    private final LabService labService;
    
    public DaySixSolver(LabService labService) {
        this.labService = labService;
    }

    @Override
    public String taskOne() {
        final LabMap labMap = LabMap.of(fileLines);

        return String.valueOf(labService.countNumberOfUniquePositionsGuardVisits(labMap));
    }

    @Override
    public String taskTwo() {
        return null;
    }
}
