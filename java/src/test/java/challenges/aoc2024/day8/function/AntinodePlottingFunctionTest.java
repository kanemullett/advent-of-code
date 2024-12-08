package challenges.aoc2024.day8.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.CoordinatePair;

class AntinodePlottingFunctionTest {

    @Test
    void shouldPlotAntinodes() {
        // Given
        final List<CoordinatePair> antennaPositions = List.of(
            CoordinatePair.of(6, 5),
            CoordinatePair.of(8, 8),
            CoordinatePair.of(9, 9)
        );
        final AntinodePlottingFunction plottingFunction = new AntinodePlottingFunction(12, 12);

        // When
        final List<CoordinatePair> antinodeLocations = plottingFunction.apply(antennaPositions);

        // Then
        assertEquals(5, antinodeLocations.size());
        assertTrue(antinodeLocations.contains(CoordinatePair.of(10, 11)));
        assertTrue(antinodeLocations.contains(CoordinatePair.of(4, 2)));
        assertTrue(antinodeLocations.contains(CoordinatePair.of(3, 1)));
        assertTrue(antinodeLocations.contains(CoordinatePair.of(10, 10)));
        assertTrue(antinodeLocations.contains(CoordinatePair.of(7, 7)));
        assertFalse(antinodeLocations.contains(CoordinatePair.of(12, 13)));
    }
}
