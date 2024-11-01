package util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AdventUtilsTest {

    @Test
    void shouldParseLinesOfTextFile() {
        // When
        final List<String> lines = AdventUtils.parseInput(2023, 1);

        // Then
        assertNotEquals(0, lines.size());
    }
}
