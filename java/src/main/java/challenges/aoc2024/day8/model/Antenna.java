package challenges.aoc2024.day8.model;

import org.immutables.value.Value.Immutable;

import model.CoordinatePair;

/**
 * Antenna object containing the frequency and position of an antenna.
 */
@Immutable
public interface Antenna {
    
    /**
     * The frequency of the antenna, represented by a single character.
     * 
     * @return The antenna's frequency.
     */
    String getFrequency();

    /**
     * The position of the antenna.
     * 
     * @return The antenna's position.
     */
    CoordinatePair getPosition();

    /**
     * Build an Antenna object from its frequency and position.
     * 
     * @param frequency The antenna's frequency.
     * @param position The antenna's position.
     * 
     * @return The Antenna object.
     */
    static Antenna of(String frequency, CoordinatePair position) {

        return ImmutableAntenna.builder()
            .frequency(frequency)
            .position(position)
            .build();
    }
}
