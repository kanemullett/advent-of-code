package challenges.aoc2023.day2.service;

import challenges.aoc2023.day2.model.BagGame;
import service.DaySolver;
import util.AdventUtils;

import java.util.List;

public class DayTwoSolver implements DaySolver {
    private final List<String> inputLines = AdventUtils.parseInput(2023, 2);
    private final BagGameService bagGameService;

    public DayTwoSolver(BagGameService bagGameService) {
        this.bagGameService = bagGameService;
    }

    public String taskOne() {
        final List<BagGame> bagGames = inputLines.stream()
            .map(BagGame::of)
            .toList();

        return bagGameService.calculateTotalOfPossibleIds(bagGames);
    }

    public String taskTwo() {
        return null;
    }
}
