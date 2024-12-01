package challenges.aoc2023.day1.function;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalibrationLineToValueFunctionTest {

    @ParameterizedTest
    @CsvSource({
        "1abc2, 12",
        "pqr3stu8vwx, 38",
        "a1b2c3d4e5f, 15",
        "treb7uchet, 77",
        "78797, 77"
    })
    void shouldDecipherCalibrationValueFromLine(String calibrationLine, Integer expectedCalibrationValue) {
        // Given
        final CalibrationLineToValueFunction function = new CalibrationLineToValueFunction(false);

        // When
        final Integer calibrationValue = function.apply(calibrationLine);

        // Then
        assertEquals(expectedCalibrationValue, calibrationValue);
    }

    @ParameterizedTest
    @CsvSource({
        "oneight18one, 11",
        "two1nine, 29",
        "eightwothree, 83",
        "abcone2threexyz, 13",
        "xtwone3four, 24",
        "4nineeightseven2, 42",
        "zoneight234, 14",
        "7pqrstsixteen, 76"
    })
    void shouldDecipherCalibrationValueFromLineIncludingWords(String calibrationLine, Integer expectedCalibrationValue) {
        // Given
        final CalibrationLineToValueFunction function = new CalibrationLineToValueFunction(true);

        // When
        final Integer calibrationValue = function.apply(calibrationLine);

        // Then
        assertEquals(expectedCalibrationValue, calibrationValue);
    }
}
