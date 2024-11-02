package challenges.aoc2023.day1.service;

import challenges.aoc2023.day1.function.CalibrationLineToValueFunction;
import challenges.aoc2023.day1.model.CalibrationDocument;

public class CalibrationService {

    public CalibrationService() {
        // Empty constructor for dependency injection
    }

    public Integer calculateCalibrationValueTotal(CalibrationDocument calibrationDocument, boolean textNumbersCountAsIntegers) {

        return calibrationDocument.getCalibrationLines().stream()
            .map(new CalibrationLineToValueFunction(textNumbersCountAsIntegers))
            .mapToInt(Integer::intValue)
            .sum();
    }
}
