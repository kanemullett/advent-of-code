package challenges.aoc2023.day1.model;

import org.immutables.value.Value.Immutable;

import java.util.List;

@Immutable
public interface CalibrationDocument {

    List<String> getCalibrationLines();

    static CalibrationDocument of(List<String> calibrationLines) {
        return ImmutableCalibrationDocument.builder()
                .calibrationLines(calibrationLines)
                .build();
    }
}
