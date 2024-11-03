package challenges.aoc2023.day1.service;

import challenges.aoc2023.day1.model.CalibrationDocument;
import service.DaySolver;
import util.AdventUtils;

import java.util.List;

/**
 * Solver class for the tasks of Day 1 of the 2023 Advent of Code.
 */
public class DayOneSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2023, 1);
    private final CalibrationService calibrationService;

    /**
     * Solver class for the tasks of Day 1 of the 2023 Advent of Code.
     *
     * @param calibrationService The calibration service used to perform calibration procedures.
     */
    public DayOneSolver(CalibrationService calibrationService) {
        this.calibrationService = calibrationService;
    }

    /**
     * Solve the first task of Day 1 of the 2023 Advent of Code.
     *
     * @return The solution to the first task.
     */
    @Override
    public String taskOne() {
        final CalibrationDocument calibrationDocument = CalibrationDocument.of(inputLines);

        return String.valueOf(calibrationService.calculateCalibrationValueTotal(calibrationDocument, false));
    }

    /**
     * Solve the second task of Day 1 of the 2023 Advent of Code.
     *
     * @return The solution to the second task.
     */
    @Override
    public String taskTwo() {
        final CalibrationDocument calibrationDocument = CalibrationDocument.of(inputLines);

        return String.valueOf(calibrationService.calculateCalibrationValueTotal(calibrationDocument, true));
    }
}
