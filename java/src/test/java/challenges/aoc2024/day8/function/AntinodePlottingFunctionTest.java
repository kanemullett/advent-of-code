package challenges.aoc2024.day8.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import challenges.aoc2024.day8.model.CityMap;
import model.CoordinatePair;

class AntinodePlottingFunctionTest {

    @ParameterizedTest
    @CsvSource({
        "false, 10",
        "true, 21"
    })
    void shouldPlotAntinodes(boolean applyResonantHarmonics, Integer locationCount) {
        // Given
        final List<CoordinatePair> antennaPositions = List.of(
            CoordinatePair.of(8, 1),
            CoordinatePair.of(5, 2),
            CoordinatePair.of(7, 3),
            CoordinatePair.of(4, 4)
        );

        final CityMap cityMap = mock(CityMap.class);
        when(cityMap.getHeight()).thenReturn(12);
        when(cityMap.getWidth()).thenReturn(12);

        final AntinodePlottingFunction plottingFunction = new AntinodePlottingFunction(cityMap, applyResonantHarmonics);

        // When
        final List<CoordinatePair> antinodeLocations = plottingFunction.apply(antennaPositions);

        // Then
        assertEquals(locationCount, antinodeLocations.size());
    }
}
