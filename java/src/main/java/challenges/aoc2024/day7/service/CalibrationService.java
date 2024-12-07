package challenges.aoc2024.day7.service;

import java.util.List;

import challenges.aoc2024.day7.function.CalibrationValuePredicate;
import challenges.aoc2024.day7.model.CalibrationEquation;

/**
 * Service for calibrating numbers of calibration equations.
 */
public class CalibrationService {
    
    public CalibrationService() {
        // Empty constructor for dependency injection
    }

    /**
     * Calculate the total calibration result from a list of calibration equations.
     * 
     * @param equations The equations to calibrate.
     * @param includeConcatenation True if equations can include || operator.
     * 
     * @return The total calibration result.
     */
    public Long calculateTotalCalibrationResult(List<CalibrationEquation> equations, boolean includeConcatenation) {

        return equations.stream()
            .filter(new CalibrationValuePredicate(includeConcatenation))
            .map(CalibrationEquation::getTestValue)
            .mapToLong(Long::longValue)
            .sum();
    }
}
