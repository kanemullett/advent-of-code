package challenges.aoc2024.day5.model;

import org.immutables.value.Value.Immutable;

/**
 * PageOrderingRule object containing the ordering rule for two pages.
 */
@Immutable
public interface PageOrderingRule {
    
    /**
     * The page that should be first when ordering the two pages.
     * 
     * @return The before page number.
     */
    Integer getBeforeNumber();

    /**
     * The page that should be second when ordering the two pages.
     * 
     * @return The after page number.
     */
    Integer getAfterNumber();

    /**
     * Build a PageOrderingRule object from a rule string.
     * 
     * @param ruleString The rule string.
     * 
     * @return PageOrderingRule object.
     */
    static PageOrderingRule of(String ruleString) {
        final String[] ruleParts = ruleString.split("\\|");

        return ImmutablePageOrderingRule.builder()
            .beforeNumber(Integer.parseInt(ruleParts[0]))
            .afterNumber(Integer.parseInt(ruleParts[1]))
            .build();
    }
}
