package challenges.aoc2024.day4.model;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CoordinatePair {
    
    Integer getXCoordinate();

    Integer getYCoordinate();

    static CoordinatePair of(Integer xCoordinate, Integer yCoordinate) {
        
        return ImmutableCoordinatePair.builder()
            .xCoordinate(xCoordinate)
            .yCoordinate(yCoordinate)
            .build();
    }
}
