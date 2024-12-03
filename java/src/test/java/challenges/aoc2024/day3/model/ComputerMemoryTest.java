package challenges.aoc2024.day3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ComputerMemoryTest {
    
    @Test
    void shouldBuildComputerMemoryObjectFromString() {
        // When
        final ComputerMemory memory = ComputerMemory.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        // Then
        assertEquals(ImmutableComputerMemory.class, memory.getClass());

        assertEquals(4, memory.getInstructions().size());
        assertEquals(MultiplicationInstruction.of(2, 4), memory.getInstructions().get(0));
        assertEquals(MultiplicationInstruction.of(5, 5), memory.getInstructions().get(1));
        assertEquals(MultiplicationInstruction.of(11, 8), memory.getInstructions().get(2));
        assertEquals(MultiplicationInstruction.of(8, 5), memory.getInstructions().get(3));
    }
}
