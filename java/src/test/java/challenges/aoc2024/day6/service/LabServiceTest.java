package challenges.aoc2024.day6.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenges.aoc2024.day6.model.LabMap;

class LabServiceTest {
    private LabService labService;

    @BeforeEach
    void setUp() {
        labService = new LabService();
    }

    @Test
    void shouldCountNumberOfUniquePositionsGuardVisits() {
        // Given
        final LabMap labMap = LabMap.of(List.of(
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
        ));

        // When
        final Integer count = labService.countNumberOfUniquePositionsGuardVisits(labMap);

        // Then
        assertEquals(41, count);
    }

    @Test
    void shouldCountObstructionPlacementPositions() {
        // Given
        final LabMap labMap = LabMap.of(List.of(
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
        ));

        // When
        final Integer count = labService.countObstructionPlacementPositions(labMap);

        // Then
        assertEquals(6, count);
    }
}
