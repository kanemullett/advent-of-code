package challenges.aoc2024.day5.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

class CorrectlyOrderedPagesPredicateTest {

    @ParameterizedTest
    @CsvSource({
        "'75,47,61,53,29', true",
        "'97,61,53,29,13', true",
        "'75,29,13', true",
        "'75,97,47,61,53', false",
        "'61,13,29', false",
        "'97,13,75,29,47', false"
    })
    void shouldDetermineWhetherUpdateIsCorrectlyOrdered(String updateString, boolean isCorrectlyOrdered) {
        // Given
        final ProductionUpdate productionUpdate = ProductionUpdate.of(updateString);
        
        final List<PageOrderingRule> pageOrderingRules = List.of(
            PageOrderingRule.of("47|53"),
            PageOrderingRule.of("97|13"),
            PageOrderingRule.of("97|61"),
            PageOrderingRule.of("97|47"),
            PageOrderingRule.of("75|29"),
            PageOrderingRule.of("61|13"),
            PageOrderingRule.of("75|53"),
            PageOrderingRule.of("29|13"),
            PageOrderingRule.of("97|29"),
            PageOrderingRule.of("53|29"),
            PageOrderingRule.of("61|53"),
            PageOrderingRule.of("97|53"),
            PageOrderingRule.of("61|29"),
            PageOrderingRule.of("47|13"),
            PageOrderingRule.of("75|47"),
            PageOrderingRule.of("97|75"),
            PageOrderingRule.of("47|61"),
            PageOrderingRule.of("75|61"),
            PageOrderingRule.of("47|29"),
            PageOrderingRule.of("75|13"),
            PageOrderingRule.of("53|13")
        );

        final CorrectlyOrderedPagesPredicate predicate = new CorrectlyOrderedPagesPredicate(pageOrderingRules);

        // When
        final boolean ordered = predicate.test(productionUpdate);

        // Then
        assertEquals(isCorrectlyOrdered, ordered);
    }
}
