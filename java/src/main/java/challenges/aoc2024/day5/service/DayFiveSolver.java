package challenges.aoc2024.day5.service;

import java.util.List;

import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;
import service.DaySolver;
import util.AdventUtils;

/**
 * Solver class for the tasks of Day 5 of the 2024 Advent of Code.
 */
public class DayFiveSolver implements DaySolver {
    private final List<String> fileLines = AdventUtils.parseInput(2024, 5);
    private final PageProductionService pageProductionService;
    
    /**
     * Solver class for the tasks of Day 5 of the 2024 Advent of Code.
     * 
     * @param pageProductionService The page production service used to perform page production update functions.
     */
    public DayFiveSolver(PageProductionService pageProductionService) {
        this.pageProductionService = pageProductionService;
    }

    /**
     * Solve the first task of Day 5 of the 2024 Advent of Code.
     * 
     * @return The solution of the first task.
     */
    @Override
    public String taskOne() {
        final List<PageOrderingRule> pageOrderingRules = fileLines.stream()
            .filter(populated -> populated.contains("|"))
            .map(PageOrderingRule::of)
            .toList();

        final List<ProductionUpdate> productionUpdates = fileLines.stream()
            .filter(line -> !line.isEmpty())
            .filter(populated -> !populated.contains("|"))
            .map(ProductionUpdate::of)
            .toList();

        return String.valueOf(pageProductionService.calculateTotalOfMiddleNumberInCorrectUpdates(pageOrderingRules, productionUpdates));
    }

    /**
     * Solve the second task of Day 5 of the 2024 Advent of Code.
     * 
     * @return The solution of the second task.
     */
    @Override
    public String taskTwo() {
        final List<PageOrderingRule> pageOrderingRules = fileLines.stream()
            .filter(populated -> populated.contains("|"))
            .map(PageOrderingRule::of)
            .toList();

        final List<ProductionUpdate> productionUpdates = fileLines.stream()
            .filter(line -> !line.isEmpty())
            .filter(populated -> !populated.contains("|"))
            .map(ProductionUpdate::of)
            .toList();

        return String.valueOf(pageProductionService.calculateTotalOfMiddleNumberInReorderedIncorrectUpdates(pageOrderingRules, productionUpdates));
    }
}
