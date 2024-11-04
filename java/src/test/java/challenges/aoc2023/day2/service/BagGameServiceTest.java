package challenges.aoc2023.day2.service;

import challenges.aoc2023.day2.model.BagGame;
import challenges.aoc2023.day2.model.BallReveal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagGameServiceTest {
    private BagGameService bagGameService;

    @BeforeEach
    void setUp() {
        bagGameService = new BagGameService();
    }

    @Test
    void shouldCalculateIdTotalOfPossibleGames() {
        // Given
        final List<BagGame> bagGames = List.of(
            BagGame.of(1, List.of(
                BallReveal.of(4, 0, 3),
                BallReveal.of(1, 2, 6),
                BallReveal.of(0, 2, 0)
            )),
            BagGame.of(2, List.of(
                BallReveal.of(0, 2, 1),
                BallReveal.of(1, 3, 4),
                BallReveal.of(0, 1, 1)
            )),
            BagGame.of(3, List.of(
                BallReveal.of(20, 8, 6),
                BallReveal.of(4, 13, 5),
                BallReveal.of(1, 5, 0)
            )),
            BagGame.of(4, List.of(
                BallReveal.of(3, 1, 6),
                BallReveal.of(6, 3, 0),
                BallReveal.of(14, 3, 15)
            )),
            BagGame.of(5, List.of(
                BallReveal.of(6, 3, 1),
                BallReveal.of(1, 2, 2)
            ))
        );

        // When
        final String totalId = bagGameService.calculateTotalOfPossibleIds(bagGames);

        // Then
        assertEquals("8", totalId);
    }
}
