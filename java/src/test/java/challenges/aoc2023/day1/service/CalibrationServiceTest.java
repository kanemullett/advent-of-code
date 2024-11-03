package challenges.aoc2023.day1.service;

import challenges.aoc2023.day1.model.CalibrationDocument;
import challenges.aoc2023.day1.service.CalibrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalibrationServiceTest {
    private CalibrationService calibrationService;

    @BeforeEach
    void setup() {
        calibrationService = new CalibrationService();
    }

    @Test
    void shouldCalculateTotalOfCalibrationValues() {
        // Given
        final CalibrationDocument calibrationDocument = mock(CalibrationDocument.class);
        when(calibrationDocument.getCalibrationLines())
            .thenReturn(List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"));

        // When
        final Integer total = calibrationService.calculateCalibrationValueTotal(calibrationDocument, false);

        // Then
        assertEquals(142, total);
    }

    @Test
    void shouldCalculateTotalOfCalibrationValuesIncludingWords() {
        // Given
        final CalibrationDocument calibrationDocument = mock(CalibrationDocument.class);
        when(calibrationDocument.getCalibrationLines())
            .thenReturn(List.of(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"
            ));

        // When
        final Integer total = calibrationService.calculateCalibrationValueTotal(calibrationDocument, true);

        // Then
        assertEquals(281, total);
    }
}
