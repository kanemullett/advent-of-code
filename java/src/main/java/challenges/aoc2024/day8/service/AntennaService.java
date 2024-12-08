package challenges.aoc2024.day8.service;

import java.util.List;

import challenges.aoc2024.day8.function.AntinodePlottingFunction;
import challenges.aoc2024.day8.model.Antenna;
import challenges.aoc2024.day8.model.CityMap;

public class AntennaService {
    
    public AntennaService() {
        // Empty constructor for dependency injection
    }

    public Integer countUniqueAntinodePositions(CityMap cityMap) {

        return cityMap.getAntennas().stream()
            .map(Antenna::getFrequency)
            .distinct()
            .map(frequency -> cityMap.getAntennas().stream()
                .filter(antenna -> frequency.equals(antenna.getFrequency()))
                .map(Antenna::getPosition)
                .toList())
            .map(new AntinodePlottingFunction(cityMap.getHeight(), cityMap.getWidth()))
            .flatMap(List::stream)
            .distinct()
            .toList().size();
    }
}
