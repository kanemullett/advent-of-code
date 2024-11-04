package challenges.aoc2023.day2.function;

import challenges.aoc2023.day2.model.BagGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerDeterminerFunctionTest {

    @ParameterizedTest
    @CsvSource({
        "'Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green', 48",
        "'Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue', 12",
        "'Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red', 1560",
        "'Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red', 630",
        "'Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green', 36"
    })
    void shouldDetermineThePowerOfAGame(String gameString, Integer expectedPower) {
        // Given
        final PowerDeterminerFunction powerDeterminerFunction = new PowerDeterminerFunction();
        final BagGame bagGame = BagGame.of(gameString);

        // When
        final Integer power = powerDeterminerFunction.applyAsInt(bagGame);

        // Then
        assertEquals(expectedPower, power);
    }
}
