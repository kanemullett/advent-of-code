package challenges.aoc2024.day6.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

class LabGuardTest {

    @Test
    void shouldBuildLabGuardObjectFromDirectionAndPosition() {
        // Given
        final Direction facing = Direction.UP;
        final CoordinatePair position = CoordinatePair.of(23, 47);

        // When
        final LabGuard labGuard = LabGuard.of(facing, position);

        // Then
        assertEquals(ImmutableLabGuard.class, labGuard.getClass());
        assertEquals(facing, labGuard.getFacing());
        assertEquals(position, labGuard.getPosition());
    }
}
