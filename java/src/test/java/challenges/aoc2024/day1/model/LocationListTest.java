package challenges.aoc2024.day1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class LocationListTest {

    @Test
    void shouldBuildLocationListObjectFromInputStrings() {
        // Given
        final List<String> inputStrings = List.of("3   4", "4   3", "2   5", "1   3", "3   9", "3   3");

        // When
        final LocationList locationList = LocationList.of(inputStrings);

        // Then
        assertEquals(6, locationList.getLinePairs().size());

        assertEquals(ListLinePair.of(1, 3), locationList.getLinePairs().get(0));
        assertEquals(ListLinePair.of(2, 3), locationList.getLinePairs().get(1));
        assertEquals(ListLinePair.of(3, 3), locationList.getLinePairs().get(2));
        assertEquals(ListLinePair.of(3, 4), locationList.getLinePairs().get(3));
        assertEquals(ListLinePair.of(3, 5), locationList.getLinePairs().get(4));
        assertEquals(ListLinePair.of(4, 9), locationList.getLinePairs().get(5));
    }
}
