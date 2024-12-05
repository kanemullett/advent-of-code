package challenges.aoc2024.day5.model;

import org.immutables.value.Value.Immutable;

@Immutable
public interface PageOrderingRule {
    
    Integer getBeforeNumber();

    Integer getAfterNumber();

    static PageOrderingRule of(String ruleString) {
        final String[] ruleParts = ruleString.split("\\|");

        return ImmutablePageOrderingRule.builder()
            .beforeNumber(Integer.parseInt(ruleParts[0]))
            .afterNumber(Integer.parseInt(ruleParts[1]))
            .build();
    }
}
