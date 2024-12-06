package challenges.aoc2024.day5.service;

import java.util.List;

import challenges.aoc2024.day5.function.CorrectlyOrderedPagesPredicate;
import challenges.aoc2024.day5.function.PageOrderingFunction;
import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

/**
 * Service for performing page production update functions.
 */
public class PageProductionService {
    
    public PageProductionService() {
        // Empty constructor for dependency injection
    }

    /**
     * Calculate the total of the middle values from all updates which contain pages that are in the correct order.
     * 
     * @param orderingRules The rules to order pages by.
     * @param productionUpdates The production updates containing the pages.
     * 
     * @return The total of the middle values.
     */
    public Integer calculateTotalOfMiddleNumberInCorrectUpdates(List<PageOrderingRule> orderingRules, List<ProductionUpdate> productionUpdates) {

        return productionUpdates.stream()
            .filter(new CorrectlyOrderedPagesPredicate(orderingRules))
            .map(update -> update.getPages().get(update.getPages().size() / 2))
            .mapToInt(Integer::intValue)
            .sum();
    }

    /**
     * Calculate the total of the middle values from all updates which contain pages that are in the incorrect order after they have been
     * reordered.
     * 
     * @param orderingRules The rules to order pages by.
     * @param productionUpdates The production updates containing the pages.
     * 
     * @return The total of the middle values.
     */
    public Integer calculateTotalOfMiddleNumberInReorderedIncorrectUpdates(List<PageOrderingRule> orderingRules, List<ProductionUpdate> productionUpdates) {

        return productionUpdates.stream()
            .filter(new CorrectlyOrderedPagesPredicate(orderingRules).negate())
            .map(new PageOrderingFunction(orderingRules))
            .map(update -> update.getPages().get(update.getPages().size() / 2))
            .mapToInt(Integer::intValue)
            .sum();
    }
}
