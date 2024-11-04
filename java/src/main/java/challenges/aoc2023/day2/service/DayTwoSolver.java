package challenges.aoc2023.day2.service;

import challenges.aoc2023.day2.model.BagGame;
import service.DaySolver;
import util.AdventUtils;

import java.util.List;

/**
 * Solver class for the tasks of Day 2 of the 2023 Advent of Code.
 */
public class DayTwoSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2023, 2);
    private final BagGameService bagGameService;

    /**
     * Solver class for the tasks of Day 2 of the 2023 Advent of Code.
     *
     * @param bagGameService The bag game service used to perform bag game operations.
     */
    public DayTwoSolver(BagGameService bagGameService) {
        this.bagGameService = bagGameService;
    }

    /**
     * Solve the first task of Day 2 of the 2023 Advent of Code.
     *
     * @return The solution to the first task.
     */
    public String taskOne() {
        final List<BagGame> bagGames = inputLines.stream()
            .map(BagGame::of)
            .toList();

        return bagGameService.calculateTotalOfPossibleIds(bagGames);
    }

    /**
     * Solve the second task of Day 2 of the 2023 Advent of Code.
     *
     * @return The solution to the second task.
     */
    public String taskTwo() {
        final List<BagGame> bagGames = inputLines.stream()
            .map(BagGame::of)
            .toList();

        return bagGameService.calculateTotalOfCubePowers(bagGames);
    }
}
