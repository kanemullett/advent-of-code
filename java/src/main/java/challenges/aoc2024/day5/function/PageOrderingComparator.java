package challenges.aoc2024.day5.function;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import challenges.aoc2024.day5.model.PageOrderingRule;

/**
 * Comparator class for comparing two page numbers according to the ordering rules.
 */
public class PageOrderingComparator implements Comparator<Integer> {
    private final List<PageOrderingRule> rules;

    /**
     * Comparator class for comparing two page numbers according to the ordering rules.
     * 
     * @param rules The rules to order pages by.
     */
    public PageOrderingComparator(List<PageOrderingRule> rules) {
        this.rules = rules;
    }

    /**
     * Compare two page numbers according to the ordering rules.
     */
    @Override
    public int compare(Integer firstPage, Integer secondPage) {
        final Optional<PageOrderingRule> relevantRule = rules.stream()
            .filter(rule -> isRelevantRule(rule, firstPage, secondPage))
            .findFirst();

        if (!relevantRule.isPresent()) {
            return 0;
        }

        return Objects.equals(firstPage, relevantRule.get().getBeforeNumber()) ? -1 : 1;
    }

    /**
     * Determine if a specific ordering rule is relevant to the numbers that are being compared.
     * 
     * @param rule The rule to evaluate.
     * @param firstPage The first page number.
     * @param secondPage The second page number.
     * 
     * @return True if the rule is relevant to the numbers that are being compared.
     */
    private boolean isRelevantRule(PageOrderingRule rule, Integer firstPage, Integer secondPage) {
        
        return (Objects.equals(rule.getBeforeNumber(), firstPage) && Objects.equals(rule.getAfterNumber(), secondPage))
            || (Objects.equals(rule.getBeforeNumber(), secondPage) && Objects.equals(rule.getAfterNumber(), firstPage));
    }
    
}
