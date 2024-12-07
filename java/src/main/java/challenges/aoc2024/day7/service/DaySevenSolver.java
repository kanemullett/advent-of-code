package challenges.aoc2024.day7.service;

import java.util.List;

import challenges.aoc2024.day7.model.CalibrationEquation;
import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 7 of the 2024 Advent of Code.
 */
public class DaySevenSolver implements DaySolver {
    private static final List<String> fileLines = AdventUtils.parseInput(2024, 7);
    private final CalibrationService calibrationService;

    /**
     * Solver class for the tasks of Day 7 of the 2024 Advent of Code.
     * 
     * @param calibrationService The calibration service used to calibrate the numbers of calibration equations.
     */
    public DaySevenSolver(CalibrationService calibrationService) {
        this.calibrationService = calibrationService;
    }

    /**
     * Solve the first task of Day 7 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    @Override
    public String taskOne() {
        final List<CalibrationEquation> equations = fileLines.stream()
            .map(CalibrationEquation::of)
            .toList();

        return String.valueOf(calibrationService.calculateTotalCalibrationResult(equations, false));
    }

    /**
     * Solve the second task of Day 7 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    @Override
    public String taskTwo() {
        final List<CalibrationEquation> equations = fileLines.stream()
            .map(CalibrationEquation::of)
            .toList();

        return String.valueOf(calibrationService.calculateTotalCalibrationResult(equations, true));
    }
}
