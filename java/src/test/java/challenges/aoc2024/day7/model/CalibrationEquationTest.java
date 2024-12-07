package challenges.aoc2024.day7.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class CalibrationEquationTest {

    @Test
    void shouldBuildCalibrationEquationObjectFromString() {
        // When
        final CalibrationEquation equation = CalibrationEquation.of("7290: 6 8 6 15");

        // Then
        assertEquals(ImmutableCalibrationEquation.class, equation.getClass());
        assertEquals(7290, equation.getTestValue());

        final List<Long> values = equation.getCalibrationValues();
        assertEquals(4, values.size());
        assertEquals(6, values.get(0));
        assertEquals(8, values.get(1));
        assertEquals(6, values.get(2));
        assertEquals(15, values.get(3));
    }
}
