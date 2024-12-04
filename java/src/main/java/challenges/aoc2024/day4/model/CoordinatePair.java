package challenges.aoc2024.day4.model;

import org.immutables.value.Value.Immutable;

/**
 * CoordinatePair object containing the x and y values of a coordinate point.
 */
@Immutable
public interface CoordinatePair {
    
    /**
     * The position's x-coordinate.
     * 
     * @return The x-coordinate.
     */
    Integer getXCoordinate();

    /**
     * The position's y-coordinate.
     * 
     * @return The y-coordinate.
     */
    Integer getYCoordinate();

    /**
     * Build a CoordinatePair object from the position's x and y coordinates.
     * 
     * @param xCoordinate The x-coordinate.
     * @param yCoordinate The y-coordinate.
     * 
     * @return The CoordinatePair object.
     */
    static CoordinatePair of(Integer xCoordinate, Integer yCoordinate) {
        
        return ImmutableCoordinatePair.builder()
            .xCoordinate(xCoordinate)
            .yCoordinate(yCoordinate)
            .build();
    }
}
