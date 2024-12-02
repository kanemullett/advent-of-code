package challenges.aoc2024.day2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReactorReportTest {
    
    @Test
    void shouldBuildReactorReportObjectFromString() {
        // Given
        final String input = "7 6 4 2 1";

        // When
        final ReactorReport reactorReport = ReactorReport.of(input);

        // Then
        assertEquals(ImmutableReactorReport.class, reactorReport.getClass());
        assertEquals(5, reactorReport.getLevels().size());
        assertEquals(7, reactorReport.getLevels().get(0));
        assertEquals(6, reactorReport.getLevels().get(1));
        assertEquals(4, reactorReport.getLevels().get(2));
        assertEquals(2, reactorReport.getLevels().get(3));
        assertEquals(1, reactorReport.getLevels().get(4));
    }
}
