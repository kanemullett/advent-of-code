package challenges.aoc2024.day6.model.type;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

    @ParameterizedTest
    @CsvSource({
        "^, UP",
        ">, RIGHT",
        "v, DOWN",
        "<, LEFT"
    })
    void shouldConvertStringToDirection(String directionString, Direction expected) {
        // When
        final Direction converted = Direction.of(directionString);

        // Then
        assertEquals(expected, converted);
    }
}
