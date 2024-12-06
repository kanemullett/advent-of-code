package challenges.aoc2024.day5.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

class PageOrderingFunctionTest {

    @ParameterizedTest
    @CsvSource({
        "'75,97,47,61,53', '97,75,47,61,53'",
        "'61,13,29', '61,29,13'",
        "'97,13,75,29,47', '97,75,47,29,13'"
    })
    void shouldReorderPages(String unordered, String ordered) {
        // Given
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

        final ProductionUpdate update = ProductionUpdate.of(unordered);
        final PageOrderingFunction orderingFunction = new PageOrderingFunction(pageOrderingRules);

        // When
        final ProductionUpdate applied = orderingFunction.apply(update);

        // Then
        assertEquals(ProductionUpdate.of(ordered), applied);
    }
}
