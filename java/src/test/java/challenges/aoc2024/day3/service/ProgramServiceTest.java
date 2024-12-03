package challenges.aoc2024.day3.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProgramServiceTest {
    private ProgramService programService;

    @BeforeEach
    void setUp() {
        programService = new ProgramService();
    }

    @ParameterizedTest
    @CsvSource({
        "false, 161",
        "true, 48"
    })
    void shouldCalculateTotalOfMultiplicationInstructions(boolean conditionalsIntact, Integer expectedTotal) {
        // When
        final Integer total = programService.calculateTotalOfMultiplicationInstructions("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))", conditionalsIntact);

        // Then
        assertEquals(expectedTotal, total);
    }
}
