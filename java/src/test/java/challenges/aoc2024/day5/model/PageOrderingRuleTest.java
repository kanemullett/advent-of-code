package challenges.aoc2024.day5.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PageOrderingRuleTest {

    @Test
    void shouldBuildPageOrderingRuleObjectFromString() {
        // When
        final PageOrderingRule pageOrderingRule = PageOrderingRule.of("23|47");

        // Then
        assertEquals(ImmutablePageOrderingRule.class, pageOrderingRule.getClass());
        assertEquals(23, pageOrderingRule.getBeforeNumber());
        assertEquals(47, pageOrderingRule.getAfterNumber());
    }
}
