package challenges.aoc2023.day2.util;

import challenges.aoc2023.day2.model.BagGame;
import challenges.aoc2023.day2.model.CubeReveal;
import challenges.aoc2023.day2.model.type.CubeColour;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagGameUtilsTest {

    @ParameterizedTest
    @CsvSource({
        "RED, 4",
        "GREEN, 2",
        "BLUE, 6"
    })
    void shouldReturnMaximumShownForAColour(CubeColour colour, Integer expectedMaximum) {
        // Given
        final BagGame bagGame = BagGame.of(1, List.of(
            CubeReveal.of(4, 0, 3),
            CubeReveal.of(1, 2, 6),
            CubeReveal.of(0, 2, 0)
        ));

        // When
        final Integer maximumShown = BagGameUtils.getMaximumShownForColour(bagGame, colour);

        // Then
        assertEquals(expectedMaximum, maximumShown);
    }
}
