package service;

import challenges.aoc2023.day1.service.CalibrationService;
import challenges.aoc2023.day1.service.DayOneSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DayOneSolverTest {
    private DayOneSolver dayOneSolver;
    private final CalibrationService calibrationService = mock(CalibrationService.class);

    @BeforeEach
    void setUp() {
        dayOneSolver = new DayOneSolver(calibrationService);
    }

    @Test
    void shouldReturnTotalValueAsString() {
        // Given
        when(calibrationService.calculateCalibrationValueTotal(any()))
            .thenReturn(12345);

        // When
        final String total = dayOneSolver.taskOne();

        // Then
        assertEquals("12345", total);
    }
}
