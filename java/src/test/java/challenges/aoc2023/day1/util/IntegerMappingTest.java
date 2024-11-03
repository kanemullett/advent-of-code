package challenges.aoc2023.day1.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerMappingTest {
    private IntegerMapping integerMapping;

    @BeforeEach
    void setup() {
        integerMapping = new IntegerMapping();
    }

    @Test
    void shouldBeAbleToRetrieveIntegerValues() {
        // Given
        final List<String> expectedIntegers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

        // When
        final List<String> integers = integerMapping.getIntegers();

        // Then
        assertEquals(expectedIntegers, integers);
    }

    @Test
    void shouldBeAbleToRetrieveWordValues() {
        // Given
        final List<String> expectedWords = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        // When
        final List<String> words = integerMapping.getWords();

        // Then
        assertEquals(expectedWords, words);
    }

    @ParameterizedTest
    @CsvSource({
        "one, 1",
        "two, 2",
        "three, 3",
        "four, 4",
        "five, 5",
        "six, 6",
        "seven, 7",
        "eight, 8",
        "nine, 9"
    })
    void shouldMapWordValueToInteger(String word, String expectedInteger) {
        // When
        integerMapping.buildLookup();
        final String mapped = integerMapping.asInteger(word);

        // Then
        assertEquals(expectedInteger, mapped);
    }
}
