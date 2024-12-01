package challenges.aoc2024.day1.service;

import java.util.List;

import challenges.aoc2024.day1.model.LocationLists;
import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 1 of the 2024 Advent of Code.
 */
public class DayOneSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 1);
    private final ListService listService;

    /**
     * Solver class for the tasks of Day 1 of the 2024 Advent of Code.
     * 
     * @param listService The list service used to perform list calculations.
     */
    public DayOneSolver(ListService listService) {
        this.listService = listService;
    }

    /**
     * Solve the first task of Day 1 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    @Override
    public String taskOne() {
        final LocationLists locationLists = LocationLists.of(inputLines);
        
        return String.valueOf(listService.calculateTotalListDistance(locationLists));
    }

    /**
     * Solve the second task of Day 1 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    @Override
    public String taskTwo() {
        final LocationLists locationLists = LocationLists.of(inputLines);
        
        return String.valueOf(listService.calculateTotalSimilarityScore(locationLists));
    }
}
