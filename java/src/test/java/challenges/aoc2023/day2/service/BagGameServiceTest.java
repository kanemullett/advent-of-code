package challenges.aoc2023.day2.service;

import challenges.aoc2023.day2.model.BagGame;
import challenges.aoc2023.day2.model.CubeReveal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagGameServiceTest {
    private BagGameService bagGameService;

    private static final List<BagGame> BAG_GAMES = List.of(
        BagGame.of(1, List.of(
            CubeReveal.of(4, 0, 3),
            CubeReveal.of(1, 2, 6),
            CubeReveal.of(0, 2, 0)
        )),
        BagGame.of(2, List.of(
            CubeReveal.of(0, 2, 1),
            CubeReveal.of(1, 3, 4),
            CubeReveal.of(0, 1, 1)
        )),
        BagGame.of(3, List.of(
            CubeReveal.of(20, 8, 6),
            CubeReveal.of(4, 13, 5),
            CubeReveal.of(1, 5, 0)
        )),
        BagGame.of(4, List.of(
            CubeReveal.of(3, 1, 6),
            CubeReveal.of(6, 3, 0),
            CubeReveal.of(14, 3, 15)
        )),
        BagGame.of(5, List.of(
            CubeReveal.of(6, 3, 1),
            CubeReveal.of(1, 2, 2)
        ))
    );

    @BeforeEach
    void setUp() {
        bagGameService = new BagGameService();
    }

    @Test
    void shouldCalculateIdTotalOfPossibleGames() {
        // When
        final String totalId = bagGameService.calculateTotalOfPossibleIds(BAG_GAMES);

        // Then
        assertEquals("8", totalId);
    }

    @Test
    void shouldCalculateTotalPowerOfGames() {
        // When
        final String totalCubePowers = bagGameService.calculateTotalOfCubePowers(BAG_GAMES);

        // Then
        assertEquals("2286", totalCubePowers);
    }
}
