package challenges.aoc2024.day8.model;

import java.util.List;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

import model.CoordinatePair;

@Immutable
public interface CityMap {

    Integer getHeight();

    Integer getWidth();
    
    List<Antenna> getAntennas();

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
