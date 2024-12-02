package challenges.aoc2024.day2.service;

import java.util.List;

import challenges.aoc2024.day2.model.ReactorReport;
import service.DaySolver;
import util.AdventUtils;

public class DayTwoSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 2);
    private final ReactorReportService reactorReportService;

    public DayTwoSolver(ReactorReportService reactorReportService) {
        this.reactorReportService = reactorReportService;
    }

    @Override
    public String taskOne() {
        final List<ReactorReport> reactorReports = inputLines.stream()
            .map(ReactorReport::of)
            .toList();

        return String.valueOf(reactorReportService.calculateTotalSafeReports(reactorReports));
    }

    @Override
    public String taskTwo() {
        return null;
    }
}
