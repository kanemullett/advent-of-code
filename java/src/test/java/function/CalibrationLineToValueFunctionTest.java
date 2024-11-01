package function;

import challenges.aoc2023.day1.function.CalibrationLineToValueFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalibrationLineToValueFunctionTest {
    private CalibrationLineToValueFunction function;

    @BeforeEach
    void setUp() {
        function = new CalibrationLineToValueFunction();
    }

    @ParameterizedTest
    @CsvSource({
        "1abc2, 12",
        "pqr3stu8vwx, 38",
        "a1b2c3d4e5f, 15",
        "treb7uchet, 77"
    })
    void shouldDecipherCalibrationValueFromLine(String calibrationLine, Integer expectedCalibrationValue) {
        // When
        final Integer calibrationValue = function.apply(calibrationLine);

        // Then
        assertEquals(expectedCalibrationValue, calibrationValue);
    }
}
