package challenges.aoc2024.day7.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenges.aoc2024.day7.model.CalibrationEquation;

class CalibrationServiceTest {
    private CalibrationService calibrationService;

    @BeforeEach
    void setUp() {
        calibrationService = new CalibrationService();
    }

    @Test
    void shouldCalculateTotalCalibrationResult() {
        // Given
        final List<CalibrationEquation> equations = List.of(
            CalibrationEquation.of("190: 10 19"),
            CalibrationEquation.of("3267: 81 40 27"),
            CalibrationEquation.of("83: 17 5"),
            CalibrationEquation.of("156: 15 6"),
            CalibrationEquation.of("7290: 6 8 6 15"),
            CalibrationEquation.of("161011: 16 10 13"),
            CalibrationEquation.of("192: 17 8 14"),
            CalibrationEquation.of("21037: 9 7 18 13"),
            CalibrationEquation.of("292: 11 6 16 20")
        );

        // When
        final Long total = calibrationService.calculateTotalCalibrationResult(equations, false);

        // Then
        assertEquals(3749, total);
    }

    @Test
    void shouldCalculateTotalCalibrationResultIncludingConcatenation() {
        // Given
        final List<CalibrationEquation> equations = List.of(
            CalibrationEquation.of("190: 10 19"),
            CalibrationEquation.of("3267: 81 40 27"),
            CalibrationEquation.of("83: 17 5"),
            CalibrationEquation.of("156: 15 6"),
            CalibrationEquation.of("7290: 6 8 6 15"),
            CalibrationEquation.of("161011: 16 10 13"),
            CalibrationEquation.of("192: 17 8 14"),
            CalibrationEquation.of("21037: 9 7 18 13"),
            CalibrationEquation.of("292: 11 6 16 20")
        );

        // When
        final Long total = calibrationService.calculateTotalCalibrationResult(equations, true);

        // Then
        assertEquals(11387, total);
    }
}
