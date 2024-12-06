package challenges.aoc2024.day6.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

class LabMapTest {

    @Test
    void shouldBuildLabMapObjectFromStrings() {
        // Given
        final List<String> labStrings = List.of(
            "....#.....",
            ".........#",
            "..........",
            "..#.......",
            ".......#..",
            "..........",
            ".#..^.....",
            "........#.",
            "#.........",
            "......#..."
        );

        // When
        final LabMap labMap = LabMap.of(labStrings);

        // Then
        assertEquals(ImmutableLabMap.class, labMap.getClass());
        assertEquals(10, labMap.getHeight());
        assertEquals(10, labMap.getWidth());

        final LabGuard labGuard = labMap.getGuard();
        assertEquals(Direction.UP, labGuard.getFacing());
        assertEquals(CoordinatePair.of(4, 6), labGuard.getPosition());

        final List<CoordinatePair> obstacles = labMap.getObstacles();
        assertEquals(8, obstacles.size());
    }
}
