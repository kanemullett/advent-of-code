package challenges.aoc2023.day1.service;

import challenges.aoc2023.day1.model.CalibrationDocument;
import service.DaySolver;
import util.AdventUtils;

import java.util.List;

public class DayOneSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2023, 1);
    private final CalibrationService calibrationService;

    public DayOneSolver(CalibrationService calibrationService) {
        this.calibrationService = calibrationService;
    }

    @Override
    public String taskOne() {
        final CalibrationDocument calibrationDocument = CalibrationDocument.of(inputLines);

        return String.valueOf(calibrationService.calculateCalibrationValueTotal(calibrationDocument));
    }

    @Override
    public String taskTwo() {
        return "";
    }
}
