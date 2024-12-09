package challenges.aoc2024.day8.model;

import java.util.List;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

import model.CoordinatePair;

/**
 * CityMap object containing the city's dimensions and antennas.
 */
@Immutable
public interface CityMap {

    /**
     * The height of the city.
     * 
     * @return The city height.
     */
    Integer getHeight();

    /**
     * The width of the city.
     * 
     * @return The city width.
     */
    Integer getWidth();
    
    /**
     * The city's antennas.
     * 
     * @return The city's antennas.
     */
    List<Antenna> getAntennas();

    /**
     * Build a CityMap object from the list of the city's row strings.
     * 
     * @param cityRows The city's row strings.
     * 
     * @return The CityMap object.
     */
    static CityMap of(List<String> cityRows) {

        return ImmutableCityMap.builder()
            .height(cityRows.size())
            .width(cityRows.get(0).split("").length)
            .antennas(IntStream.range(0, cityRows.size())
            .mapToObj(rowIndex -> IntStream.range(0, cityRows.get(rowIndex).split("").length)
                .filter(colIndex -> !".".equals(cityRows.get(rowIndex).split("")[colIndex]))
                .mapToObj(antennaColIndex -> Antenna.of(cityRows.get(rowIndex).split("")[antennaColIndex], CoordinatePair.of(antennaColIndex, rowIndex)))
                .toList())
            .flatMap(List::stream)
            .toList())
            .build();
    }
}
