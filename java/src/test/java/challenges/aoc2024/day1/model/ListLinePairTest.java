package challenges.aoc2024.day1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ListLinePairTest {

    @Test
    void shouldBuildListLinePairObjectFromLeftAndRightValues() {
        // When
        final ListLinePair listLinePair = ListLinePair.of(23, 47);

        // Then
        assertEquals(ImmutableListLinePair.class, listLinePair.getClass());
        assertEquals(23, listLinePair.getLeftValue());
        assertEquals(47, listLinePair.getRightValue());
    }
}
