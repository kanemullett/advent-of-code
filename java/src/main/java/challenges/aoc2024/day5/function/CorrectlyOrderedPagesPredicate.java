package challenges.aoc2024.day5.function;

import java.util.List;
import java.util.function.Predicate;

import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

/**
 * Predicate class for determining if a ProductionUpdate's pages are ordered correctly according to the rules.
 */
public class CorrectlyOrderedPagesPredicate implements Predicate<ProductionUpdate> {
    private final List<PageOrderingRule> pageOrderingRules;

    /**
     * Predicate class for determining if a ProductionUpdate's pages are ordered correctly according to the rules.
     * 
     * @param pageOrderingRules The rules to order pages by.
     */
    public CorrectlyOrderedPagesPredicate(List<PageOrderingRule> pageOrderingRules) {
        this.pageOrderingRules = pageOrderingRules;
    }
    
    /**
     * Determine if a ProductionUpdate's pages are ordered correctly according to the rules.
     * 
     * @param productionUpdate The ProductionUpdate to check.
     * 
     * @return True if the ProductionUpdates pages are in the correct order.
     */
    @Override
    public boolean test(ProductionUpdate productionUpdate) {
        return pageOrderingRules.stream()
            .filter(rule -> !satisfiesRule(productionUpdate, rule))
            .toList().isEmpty();
    }

    /**
     * Determine if a ProductionUpdate's pages are ordered correctly according to a specific rule.
     * 
     * @param update The ProductionUpdate to check.
     * @param rule The rule to check against.
     * 
     * @return True if the ProductionUpdate satisifies the rule.
     */
    private boolean satisfiesRule(ProductionUpdate update, PageOrderingRule rule) {
        if (update.getPages().contains(rule.getBeforeNumber()) && update.getPages().contains(rule.getAfterNumber())) {
            return update.getPages().indexOf(rule.getBeforeNumber()) < update.getPages().indexOf(rule.getAfterNumber());
        }

        return true;
    }
}
