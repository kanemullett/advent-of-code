package challenges.aoc2023.day2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagGameTest {

    @Test
    void shouldBuildBagGameObject() {
        // Given
        final String gameString = "Game 1: 23 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        // When
        final BagGame bagGame = BagGame.of(gameString);

        // Then
        assertEquals(ImmutableBagGame.class, bagGame.getClass());
        assertEquals(1, bagGame.getId());
        assertEquals(3, bagGame.getReveals().size());

        final CubeReveal reveal1 = bagGame.getReveals().get(0);
        assertEquals(4, reveal1.getRed());
        assertEquals(0, reveal1.getGreen());
        assertEquals(23, reveal1.getBlue());

        final CubeReveal reveal2 = bagGame.getReveals().get(1);
        assertEquals(1, reveal2.getRed());
        assertEquals(2, reveal2.getGreen());
        assertEquals(6, reveal2.getBlue());

        final CubeReveal reveal3 = bagGame.getReveals().get(2);
        assertEquals(0, reveal3.getRed());
        assertEquals(2, reveal3.getGreen());
        assertEquals(0, reveal3.getBlue());
    }
}
