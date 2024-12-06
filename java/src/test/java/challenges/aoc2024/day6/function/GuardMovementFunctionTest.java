package challenges.aoc2024.day6.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import challenges.aoc2024.day6.model.LabGuard;
import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

class GuardMovementFunctionTest {

    @Test
    void shouldMoveStraightForwardIfNoObstacle() {
        // Given
        final List<CoordinatePair> obstacles = List.of();

        final GuardMovementFunction function = new GuardMovementFunction(obstacles);

        final LabGuard before = LabGuard.of(Direction.UP, CoordinatePair.of(2, 3));

        // When
        final LabGuard after = function.apply(before);

        // Then
        assertEquals(Direction.UP, after.getFacing());
        assertEquals(CoordinatePair.of(2, 2), after.getPosition());
    }

    @Test
    void shouldMoveRightIfObstacleInFront() {
        // Given
        final List<CoordinatePair> obstacles = List.of(CoordinatePair.of(2, 2));

        final GuardMovementFunction function = new GuardMovementFunction(obstacles);

        final LabGuard before = LabGuard.of(Direction.UP, CoordinatePair.of(2, 3));

        // When
        final LabGuard after = function.apply(before);

        // Then
        assertEquals(Direction.RIGHT, after.getFacing());
        assertEquals(CoordinatePair.of(3, 3), after.getPosition());
    }

    @Test
    void shouldMoveDownIfObstaclesInFrontAndRight() {
        // Given
        final List<CoordinatePair> obstacles = List.of(
            CoordinatePair.of(2, 2),
            CoordinatePair.of(3, 3)
        );

        final GuardMovementFunction function = new GuardMovementFunction(obstacles);

        final LabGuard before = LabGuard.of(Direction.UP, CoordinatePair.of(2, 3));

        // When
        final LabGuard after = function.apply(before);

        // Then
        assertEquals(Direction.DOWN, after.getFacing());
        assertEquals(CoordinatePair.of(2, 4), after.getPosition());
    }

    @Test
    void shouldMoveLeftIfObstaclesInFrontAndRightAndBehind() {
        // Given
        final List<CoordinatePair> obstacles = List.of(
            CoordinatePair.of(2, 2),
            CoordinatePair.of(3, 3),
            CoordinatePair.of(2, 4)
        );

        final GuardMovementFunction function = new GuardMovementFunction(obstacles);

        final LabGuard before = LabGuard.of(Direction.UP, CoordinatePair.of(2, 3));

        // When
        final LabGuard after = function.apply(before);

        // Then
        assertEquals(Direction.LEFT, after.getFacing());
        assertEquals(CoordinatePair.of(1, 3), after.getPosition());
    }
}
