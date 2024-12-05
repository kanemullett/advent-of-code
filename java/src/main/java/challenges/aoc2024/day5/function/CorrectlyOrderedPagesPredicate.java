package challenges.aoc2024.day5.function;

import java.util.List;
import java.util.function.Predicate;

import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

public class CorrectlyOrderedPagesPredicate implements Predicate<ProductionUpdate> {
    private final List<PageOrderingRule> pageOrderingRules;

    public CorrectlyOrderedPagesPredicate(List<PageOrderingRule> pageOrderingRules) {
        this.pageOrderingRules = pageOrderingRules;
    }
    
    @Override
    public boolean test(ProductionUpdate productionUpdate) {
        return pageOrderingRules.stream()
            .filter(rule -> !satisfiesRule(productionUpdate, rule))
            .toList().size() == 0;
    }

    private boolean satisfiesRule(ProductionUpdate update, PageOrderingRule rule) {
        if (update.getPages().contains(rule.getBeforeNumber()) && update.getPages().contains(rule.getAfterNumber())) {

            return update.getPages().indexOf(rule.getBeforeNumber()) < update.getPages().indexOf(rule.getAfterNumber());
        }

        return true;
    }
}
