package challenges.aoc2024.day5.service;

import java.util.List;

import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;
import service.DaySolver;
import util.AdventUtils;

public class DayFiveSolver implements DaySolver {
    private final List<String> fileLines = AdventUtils.parseInput(2024, 5);
    private final PageProductionService pageProductionService;
    
    public DayFiveSolver(PageProductionService pageProductionService) {
        this.pageProductionService = pageProductionService;
    }

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

    @Override
    public String taskTwo() {
        return null;
    }
}
