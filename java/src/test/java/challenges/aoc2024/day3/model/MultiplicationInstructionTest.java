package challenges.aoc2024.day3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MultiplicationInstructionTest {

    @Test
    void shouldBuildMultiplicationInstructionFromString() {
        // When
        final MultiplicationInstruction instruction = MultiplicationInstruction.of("mul(123,99)");

        // Then
        assertEquals(ImmutableMultiplicationInstruction.class, instruction.getClass());
        assertEquals(123, instruction.getFirstValue());
        assertEquals(99, instruction.getSecondValue());
    }

    @Test
    void shouldBuildMultiplicationInstructionFromValues() {
        // When
        final MultiplicationInstruction instruction = MultiplicationInstruction.of(123, 99);

        // Then
        assertEquals(ImmutableMultiplicationInstruction.class, instruction.getClass());
        assertEquals(123, instruction.getFirstValue());
        assertEquals(99, instruction.getSecondValue());
    }

}
