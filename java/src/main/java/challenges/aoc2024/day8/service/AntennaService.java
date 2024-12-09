package challenges.aoc2024.day8.service;

import java.util.List;

import challenges.aoc2024.day8.function.AntinodePlottingFunction;
import challenges.aoc2024.day8.model.Antenna;
import challenges.aoc2024.day8.model.CityMap;

/**
 * Service for plotting antennas and antinodes within the city.
 */
public class AntennaService {
    
    public AntennaService() {
        // Empty constructor for dependency injection
    }

    /**
     * Count the number of unique positions in the city where an antinode is located.
     * 
     * @param cityMap Map of the city.
     * @param applyResonantHarmonics True if resonant harmonics should be applied.
     * 
     * @return The number of unique antinode positions.
     */
    public Integer countUniqueAntinodePositions(CityMap cityMap, boolean applyResonantHarmonics) {

        return cityMap.getAntennas().stream()
            .map(Antenna::getFrequency)
            .distinct()
            .map(frequency -> cityMap.getAntennas().stream()
                .filter(antenna -> frequency.equals(antenna.getFrequency()))
                .map(Antenna::getPosition)
                .toList())
            .map(new AntinodePlottingFunction(cityMap, applyResonantHarmonics))
            .flatMap(List::stream)
            .distinct()
            .toList().size();
    }
}
