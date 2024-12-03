package challenges.aoc2024.day2.service;

import java.util.List;

import challenges.aoc2024.day2.model.ReactorReport;
import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 2 of the 2024 Advent of Code.
 */
public class DayTwoSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 2);
    private final ReactorReportService reactorReportService;

    /**
     * Solver class for the tasks of Day 2 of the 2024 Advent of Code.
     * 
     * @param reactorReportService The reactor report service used to perform reactor safety operations.
     */
    public DayTwoSolver(ReactorReportService reactorReportService) {
        this.reactorReportService = reactorReportService;
    }

    /**
     * Solve the first task of Day 2 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    @Override
    public String taskOne() {
        final List<ReactorReport> reactorReports = inputLines.stream()
            .map(ReactorReport::of)
            .toList();

        return String.valueOf(reactorReportService.calculateTotalSafeReports(reactorReports, false));
    }

    /**
     * Solve the second task of Day 2 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    @Override
    public String taskTwo() {
        final List<ReactorReport> reactorReports = inputLines.stream()
            .map(ReactorReport::of)
            .toList();

        return String.valueOf(reactorReportService.calculateTotalSafeReports(reactorReports, true));
    }
}
