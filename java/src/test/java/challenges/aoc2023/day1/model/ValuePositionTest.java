package challenges.aoc2023.day1.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValuePositionTest {

    @Test
    void shouldBuildValuePositionObjectFromValueAndPosition() {
        // When
        final ValuePosition valuePosition = ValuePosition.of("A", 1);

        // Then
        assertEquals(ImmutableValuePosition.class, valuePosition.getClass());
        assertEquals("A", valuePosition.getValue());
        assertEquals(1, valuePosition.getPosition());
    }
}
