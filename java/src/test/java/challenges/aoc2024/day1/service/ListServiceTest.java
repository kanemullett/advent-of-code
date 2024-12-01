package challenges.aoc2024.day1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import challenges.aoc2024.day1.model.LocationList;

class ListServiceTest {
    private ListService listService;

        @BeforeEach
        void setUp() {
            listService = new ListService();
        }

    @Test
    void testCalculateTotalListDistance() {
        // Given
        final LocationList locationList = LocationList.of(List.of("3   4", "4   3", "2   5", "1   3", "3   9", "3   3"));

        // When
        final Integer totalDistance = listService.calculateTotalListDistance(locationList);

        // Then
        assertEquals(11, totalDistance);
    }
}