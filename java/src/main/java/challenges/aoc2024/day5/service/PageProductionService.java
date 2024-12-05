package challenges.aoc2024.day5.service;

import java.util.List;

import challenges.aoc2024.day5.function.CorrectlyOrderedPagesPredicate;
import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

public class PageProductionService {
    
    public PageProductionService() {
        // Empty constructor for dependency injection
    }

    public Integer calculateTotalOfMiddleNumberInCorrectUpdates(List<PageOrderingRule> orderingRules, List<ProductionUpdate> productionUpdates) {

        return productionUpdates.stream()
            .filter(new CorrectlyOrderedPagesPredicate(orderingRules))
            .map(update -> update.getPages().get(update.getPages().size() / 2))
            .mapToInt(Integer::intValue)
            .sum();
    }
}
