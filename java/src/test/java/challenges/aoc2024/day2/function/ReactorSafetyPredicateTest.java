package challenges.aoc2024.day2.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import challenges.aoc2024.day2.model.ReactorReport;

class ReactorSafetyPredicateTest {

    @ParameterizedTest
    @CsvSource({
        "7 6 4 2 1, true",
        "1 2 7 8 9, false",
        "9 7 6 2 1, false",
        "1 3 2 4 5, false",
        "8 6 4 4 1, false",
        "1 3 6 7 9, true"
    })
    void shouldDetermineIfReactorIsSafe(String inputReport, boolean expectedSafetyOutcome) {
        // Given
        final ReactorReport reactorReport = ReactorReport.of(inputReport);
        final ReactorSafetyPredicate predicate = new ReactorSafetyPredicate();

        // When
        final boolean isSafe = predicate.test(reactorReport);

        // Then
        assertEquals(expectedSafetyOutcome, isSafe);
    }
}
