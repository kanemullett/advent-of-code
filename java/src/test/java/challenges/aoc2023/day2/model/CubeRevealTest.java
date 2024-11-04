package challenges.aoc2023.day2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeRevealTest {

    @ParameterizedTest
    @CsvSource({
        "'3 blue, 4 red', '4, 0, 3'",
        "'1 red, 2 green, 6 blue', '1, 2, 6'",
        "'2 green', '0, 2, 0'"
    })
    void shouldBuildCubeRevealObject(String revealString, String expected) {
        // Given
        final String[] expectedColours = expected.split(", ");

        // When
        final CubeReveal cubeReveal = CubeReveal.of(revealString);

        // Then
        assertEquals(ImmutableCubeReveal.class, cubeReveal.getClass());
        assertEquals(Integer.parseInt(expectedColours[0]), cubeReveal.getRed());
        assertEquals(Integer.parseInt(expectedColours[1]), cubeReveal.getGreen());
        assertEquals(Integer.parseInt(expectedColours[2]), cubeReveal.getBlue());
    }
}
