package challenges.aoc2024.day7.service;

import java.util.List;

import challenges.aoc2024.day7.function.CalibrationValuePredicate;
import challenges.aoc2024.day7.model.CalibrationEquation;

public class CalibrationService {
    
    public CalibrationService() {
        // Empty constructor for dependency injection
    }

    public Long calculateTotalCalibrationResult(List<CalibrationEquation> equations) {

        return equations.stream()
            .filter(new CalibrationValuePredicate())
            .map(CalibrationEquation::getTestValue)
            .mapToLong(Long::longValue)
            .sum();
    }
}
