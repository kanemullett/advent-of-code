package challenges.aoc2024.day5.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class ProductionUpdateTest {

    @Test
    void shouldBuildProductionUpdateObjectFromString() {
        // When
        final ProductionUpdate productionUpdate = ProductionUpdate.of("1,23,456");

        // Then
        assertEquals(ImmutableProductionUpdate.class, productionUpdate.getClass());

        final List<Integer> pages = productionUpdate.getPages();
        assertEquals(3, pages.size());
        assertEquals(1, pages.get(0));
        assertEquals(23, pages.get(1));
        assertEquals(456, pages.get(2));
    }
}
