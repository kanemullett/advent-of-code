package challenges.aoc2024.day7.model;

import java.util.List;

import org.immutables.value.Value.Immutable;

/**
 * CalibrationEquation object containing the test value and calibration values of a calibration equation.
 */
@Immutable
public interface CalibrationEquation {
    
    /**
     * The equation's test value.
     * 
     * @return The test value.
     */
    Long getTestValue();

    /**
     * The equation's calibration values.
     * 
     * @return The calibration values.
     */
    List<Long> getCalibrationValues();

    /**
     * Build a CalibrationEquation object from an equation string.
     * 
     * @param equationString The equation string.
     * 
     * @return The CalibrationEquation object.
     */
    static CalibrationEquation of(String equationString) {
        final String[] split = equationString.split(": ");

        return ImmutableCalibrationEquation.builder()
            .testValue(Long.parseLong(split[0]))
            .calibrationValues(List.of(split[1].split(" ")).stream()
                .map(Long::parseLong)
                .toList())
            .build();
    }
}
