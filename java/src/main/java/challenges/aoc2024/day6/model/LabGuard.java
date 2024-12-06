package challenges.aoc2024.day6.model;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

@Immutable
public interface LabGuard {
    
    Direction getFacing();

    CoordinatePair getPosition();

    static LabGuard of(Direction facing, CoordinatePair position) {

        return ImmutableLabGuard.builder()
            .facing(facing)
            .position(position)
            .build();
    }
}
