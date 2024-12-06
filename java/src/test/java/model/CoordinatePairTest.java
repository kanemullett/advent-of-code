package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoordinatePairTest {

    @Test
    void shouldBuildCoordinatePairObjectFromIntegerCoordinates() {
        // When
        final CoordinatePair coordinatePair = CoordinatePair.of(2, 3);

        // Then
        assertEquals(ImmutableCoordinatePair.class, coordinatePair.getClass());
        assertEquals(2, coordinatePair.getXCoordinate());
        assertEquals(3, coordinatePair.getYCoordinate());
    }
}
