package challenges.aoc2024.day8.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.CoordinatePair;

class AntennaTest {

    @Test
    void shouldBuildAntennaObjectFromFrequencyAndPosition() {
        // When
        final Antenna antenna = Antenna.of("K", CoordinatePair.of(2, 3));

        // Then
        assertEquals(ImmutableAntenna.class, antenna.getClass());
        assertEquals("K", antenna.getFrequency());
        assertEquals(CoordinatePair.of(2, 3), antenna.getPosition());
    }
}
