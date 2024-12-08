package challenges.aoc2024.day8.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenges.aoc2024.day8.model.CityMap;

class AntennaServiceTest {
    private AntennaService antennaService;

    @BeforeEach
    void setUp() {
        antennaService = new AntennaService();
    }

    @Test
    void shouldCountUniqueAntinodePositions() {
        // Given
        final List<String> rows = List.of(
            "............",
            "........0...",
            ".....0......",
            ".......0....",
            "....0.......",
            "......A.....",
            "............",
            "............",
            "........A...",
            ".........A..",
            "............",
            "............"
        );

        final CityMap cityMap = CityMap.of(rows);

        // When
        final Integer count = antennaService.countUniqueAntinodePositions(cityMap);

        // Then
        assertEquals(14, count);
    }
}
