package challenges.aoc2024.day6.model;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

/**
 * LabGuard object containing the lab guard's position and the direction they are facing.
 */
@Immutable
public interface LabGuard {
    
    /**
     * The direction the lab guard is facing.
     * 
     * @return The direction the lab guard is facing.
     */
    Direction getFacing();

    /**
     * The CoordinatePair of the position the lab guard currently occupies.
     * 
     * @return The positon of the lab guard.
     */
    CoordinatePair getPosition();

    /**
     * Build a LabGuard object from its location and the direction it's facing.
     * 
     * @param facing The direction the lab guard is facing.
     * @param position The position the lab guard occupies.
     * 
     * @return The LabGuard object.
     */
    static LabGuard of(Direction facing, CoordinatePair position) {

        return ImmutableLabGuard.builder()
            .facing(facing)
            .position(position)
            .build();
    }
}
