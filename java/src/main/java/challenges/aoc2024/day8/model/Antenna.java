package challenges.aoc2024.day8.model;

import org.immutables.value.Value.Immutable;

import model.CoordinatePair;

@Immutable
public interface Antenna {
    
    String getFrequency();

    CoordinatePair getPosition();

    static Antenna of(String frequency, CoordinatePair position) {

        return ImmutableAntenna.builder()
            .frequency(frequency)
            .position(position)
            .build();
    }
}
