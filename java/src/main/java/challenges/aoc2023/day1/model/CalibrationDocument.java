package challenges.aoc2023.day1.model;

import org.immutables.value.Value.Immutable;

import java.util.List;

/**
 * CalibrationDocument object containing the raw lines needed to calibrate the trebuchet.
 */
@Immutable
public interface CalibrationDocument {

    /**
     * The calibration lines used to calibrate the trebuchet.
     *
     * @return List of calibration lines.
     */
    List<String> getCalibrationLines();

    /**
     * Build a CalibrationDocument object from the given calibration lines.
     *
     * @param calibrationLines List of calibration lines.
     *
     * @return CalibrationDocument object.
     */
    static CalibrationDocument of(List<String> calibrationLines) {
        return ImmutableCalibrationDocument.builder()
                .calibrationLines(calibrationLines)
                .build();
    }
}
