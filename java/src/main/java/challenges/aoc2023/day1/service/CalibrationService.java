package challenges.aoc2023.day1.service;

import challenges.aoc2023.day1.function.CalibrationLineToValueFunction;
import challenges.aoc2023.day1.model.CalibrationDocument;

/**
 * Service for performing calibration procedures.
 */
public class CalibrationService {

    public CalibrationService() {
        // Empty constructor for dependency injection
    }

    /**
     * Calculate the total of the calibration values deciphered from a calibration document.
     *
     * @param calibrationDocument The calibration document to decipher.
     * @param textNumbersCountAsIntegers True if text numbers should be counted as integers, false otherwise.
     *
     * @return The total of the calibration values.
     */
    public Integer calculateCalibrationValueTotal(CalibrationDocument calibrationDocument, boolean textNumbersCountAsIntegers) {

        return calibrationDocument.getCalibrationLines().stream()
            .map(new CalibrationLineToValueFunction(textNumbersCountAsIntegers))
            .mapToInt(Integer::intValue)
            .sum();
    }
}
