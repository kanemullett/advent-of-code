package challenges.aoc2024.day8.service;

import java.util.List;

import challenges.aoc2024.day8.model.CityMap;
import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 8 of the 2024 Advent of Code.
 */
public class DayEightSolver implements DaySolver {
    private static final List<String> fileLines = AdventUtils.parseInput(2024, 8);
    private final AntennaService antennaService;
    
    /**
     * Solver class for the tasks of Day 8 of the 2024 Advent of Code.
     * 
     * @param antennaService The antenna service used to plot antennas and antinodes.
     */
    public DayEightSolver(AntennaService antennaService) {
        this.antennaService = antennaService;
    }

    /**
     * Solve the first task of Day 8 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    @Override
    public String taskOne() {
        final CityMap cityMap = CityMap.of(fileLines);

        return String.valueOf(antennaService.countUniqueAntinodePositions(cityMap, false));
    }

    /**
     * Solve the second task of Day 8 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    @Override
    public String taskTwo() {
        final CityMap cityMap = CityMap.of(fileLines);

        return String.valueOf(antennaService.countUniqueAntinodePositions(cityMap, true));
    }
}
