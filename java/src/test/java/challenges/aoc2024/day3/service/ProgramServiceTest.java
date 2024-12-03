package challenges.aoc2024.day3.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenges.aoc2024.day3.model.ComputerMemory;

class ProgramServiceTest {
    private ProgramService programService;

    @BeforeEach
    void setUp() {
        programService = new ProgramService();
    }

    @Test
    void shouldCalculateTotalOfMultiplicationInstructions() {
        // Given
        final ComputerMemory memory = ComputerMemory.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        // When
        final Integer total = programService.calculateTotalOfMultiplicationInstructions(memory);

        // Then
        assertEquals(161, total);
    }
}
