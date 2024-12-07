package challenges.aoc2024.day7.service;

import java.util.List;

import challenges.aoc2024.day7.model.CalibrationEquation;
import service.DaySolver;
import util.AdventUtils;

public class DaySevenSolver implements DaySolver {
    private static final List<String> fileLines = AdventUtils.parseInput(2024, 7);
    private final CalibrationService calibrationService;

    public DaySevenSolver(CalibrationService calibrationService) {
        this.calibrationService = calibrationService;
    }

    @Override
    public String taskOne() {
        final List<CalibrationEquation> equations = fileLines.stream()
            .map(CalibrationEquation::of)
            .toList();

        return String.valueOf(calibrationService.calculateTotalCalibrationResult(equations));
    }

    @Override
    public String taskTwo() {

        return null;
    }
}
