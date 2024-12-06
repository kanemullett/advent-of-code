package challenges.aoc2024.day5.function;

import java.util.List;
import java.util.function.UnaryOperator;

import challenges.aoc2024.day5.model.ImmutableProductionUpdate;
import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

/**
 * Function for reordering the pages of a ProductionUpdate according to the ordering rules.
 */
public class PageOrderingFunction implements UnaryOperator<ProductionUpdate> {
    private final List<PageOrderingRule> rules;

    /**
     * Function for reordering the pages of a ProductionUpdate according to the ordering rules.
     * 
     * @param rules The rules to order pages by.
     */
    public PageOrderingFunction(List<PageOrderingRule> rules) {
        this.rules = rules;
    }
    
    /**
     * Reorder the pages of a ProductionUpdate according to the ordering rules.
     * 
     * @param update The ProductionUpdate whose pages are to be reordered.
     * 
     * @return ProductionUpdate with reordered pages.
     */
    @Override
    public ProductionUpdate apply(ProductionUpdate update) {
        
        return ImmutableProductionUpdate.copyOf(update)
            .withPages(update.getPages().stream()
                .sorted(new PageOrderingComparator(rules))
                .toList());
    }
}
