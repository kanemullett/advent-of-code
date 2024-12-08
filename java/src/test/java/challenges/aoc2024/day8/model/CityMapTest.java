package challenges.aoc2024.day8.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.CoordinatePair;

class CityMapTest {

    @Test
    void shouldBuildCityMapObjectFromRowStrings() {
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

        // When
        final CityMap city = CityMap.of(rows);

        // Then
        assertEquals(ImmutableCityMap.class, city.getClass());

        final List<Antenna> antennas = city.getAntennas();
        assertEquals(7, antennas.size());
        assertAntenna(antennas.get(0), "0", CoordinatePair.of(8, 1));
        assertAntenna(antennas.get(1), "0", CoordinatePair.of(5, 2));
        assertAntenna(antennas.get(2), "0", CoordinatePair.of(7, 3));
        assertAntenna(antennas.get(3), "0", CoordinatePair.of(4, 4));
        assertAntenna(antennas.get(4), "A", CoordinatePair.of(6, 5));
        assertAntenna(antennas.get(5), "A", CoordinatePair.of(8, 8));
        assertAntenna(antennas.get(6), "A", CoordinatePair.of(9, 9));
    }

    private static void assertAntenna(Antenna antenna, String expectedFrequency, CoordinatePair expectedPosition) {

        assertEquals(expectedFrequency, antenna.getFrequency());
        assertEquals(expectedPosition, antenna.getPosition());
    }
}
