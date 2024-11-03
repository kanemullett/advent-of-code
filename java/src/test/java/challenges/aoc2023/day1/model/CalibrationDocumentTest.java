package challenges.aoc2023.day1.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalibrationDocumentTest {

    @Test
    void shouldBuildCalibrationDocumentFromLines() {
        // Given
        final List<String> calibrationLines = List.of("foo", "bar", "baz");

        // When
        final CalibrationDocument calibrationDocument = CalibrationDocument.of(calibrationLines);

        // Then
        assertEquals(ImmutableCalibrationDocument.class, calibrationDocument.getClass());
        assertEquals(calibrationLines, calibrationDocument.getCalibrationLines());
    }
}
