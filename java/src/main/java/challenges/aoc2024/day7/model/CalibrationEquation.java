package challenges.aoc2024.day7.model;

import java.util.List;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CalibrationEquation {
    
    Long getTestValue();

    List<Long> getCalibrationValues();

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
