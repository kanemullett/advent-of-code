package challenges.aoc2023.day2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallRevealTest {

    @ParameterizedTest
    @CsvSource({
        "'3 blue, 4 red', '4, 0, 3'",
        "'1 red, 2 green, 6 blue', '1, 2, 6'",
        "'2 green', '0, 2, 0'"
    })
    void shouldBuildBallRevealObject(String revealString, String expected) {
        // Given
        final String[] expectedColours = expected.split(", ");

        // When
        final BallReveal ballReveal = BallReveal.of(revealString);

        // Then
        assertEquals(ImmutableBallReveal.class, ballReveal.getClass());
        assertEquals(Integer.parseInt(expectedColours[0]), ballReveal.getRed());
        assertEquals(Integer.parseInt(expectedColours[1]), ballReveal.getGreen());
        assertEquals(Integer.parseInt(expectedColours[2]), ballReveal.getBlue());
    }
}
