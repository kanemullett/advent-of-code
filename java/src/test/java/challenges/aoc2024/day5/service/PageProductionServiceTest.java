package challenges.aoc2024.day5.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenges.aoc2024.day5.model.PageOrderingRule;
import challenges.aoc2024.day5.model.ProductionUpdate;

class PageProductionServiceTest {
    private PageProductionService pageProductionService;

    @BeforeEach
    void setUp() {
        pageProductionService = new PageProductionService();
    }

    @Test
    void shouldCalculateTotalOfMiddleNumberInCorrectUpdates() {
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

        final List<ProductionUpdate> productionUpdates = List.of(
            ProductionUpdate.of("75,47,61,53,29"),
            ProductionUpdate.of("97,61,53,29,13"),
            ProductionUpdate.of("75,29,13"),
            ProductionUpdate.of("75,97,47,61,53"),
            ProductionUpdate.of("61,13,29"),
            ProductionUpdate.of("97,13,75,29,47")
        );

        // When
        final Integer total = pageProductionService.calculateTotalOfMiddleNumberInCorrectUpdates(pageOrderingRules, productionUpdates);

        // Then
        assertEquals(143, total);
    }

    @Test
    void shouldCalculateTotalOfMiddleNumberInReorderedIncorrectUpdates() {
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

        final List<ProductionUpdate> productionUpdates = List.of(
            ProductionUpdate.of("75,47,61,53,29"),
            ProductionUpdate.of("97,61,53,29,13"),
            ProductionUpdate.of("75,29,13"),
            ProductionUpdate.of("75,97,47,61,53"),
            ProductionUpdate.of("61,13,29"),
            ProductionUpdate.of("97,13,75,29,47")
        );

        // When
        final Integer total = pageProductionService.calculateTotalOfMiddleNumberInReorderedIncorrectUpdates(pageOrderingRules, productionUpdates);

        // Then
        assertEquals(123, total);
    }
}
