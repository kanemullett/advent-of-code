package challenges.aoc2024.day1.service;

import java.util.List;

import challenges.aoc2024.day1.model.LocationList;
import service.DaySolver;
import util.AdventUtils;

public class DayOneSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2024, 1);
    private final ListService listService;

    public DayOneSolver(ListService listService) {
        this.listService = listService;
    }

    @Override
    public String taskOne() {
        final LocationList locationList = LocationList.of(inputLines);
        
        return String.valueOf(listService.calculateTotalListDistance(locationList));
    }

    @Override
    public String taskTwo() {
        return null;
    }
}
