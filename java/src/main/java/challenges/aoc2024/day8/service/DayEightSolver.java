package challenges.aoc2024.day8.service;

import java.util.List;

import challenges.aoc2024.day8.model.CityMap;
import service.DaySolver;
import util.AdventUtils;

public class DayEightSolver implements DaySolver {
    private static final List<String> fileLines = AdventUtils.parseInput(2024, 8);
    private final AntennaService antennaService;
    
    public DayEightSolver(AntennaService antennaService) {
        this.antennaService = antennaService;
    }

    @Override
    public String taskOne() {
        final CityMap cityMap = CityMap.of(fileLines);

        return String.valueOf(antennaService.countUniqueAntinodePositions(cityMap));
    }

    @Override
    public String taskTwo() {
        
        return null;
    }
}
