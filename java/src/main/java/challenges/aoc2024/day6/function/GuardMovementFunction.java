package challenges.aoc2024.day6.function;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import challenges.aoc2024.day6.model.ImmutableLabGuard;
import challenges.aoc2024.day6.model.LabGuard;
import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

/**
 * Function class for moving the lab guard along their path.
 */
public class GuardMovementFunction implements UnaryOperator<LabGuard> {
    private final List<CoordinatePair> obstacles;
    
    /**
     * Function class for moving the lab guard along their path.
     * 
     * @param obstacles List of CoordinatePair objects where obstacles are positioned in the lab.
     */
    public GuardMovementFunction(List<CoordinatePair> obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * Apply function logic to move the lab guard along their path.
     */
    @Override
    public LabGuard apply(LabGuard labGuard) {
        LabGuard current = labGuard;

        if (obstacles.contains(getNextPosition(current))) {
            current = Stream.iterate(current, this::turn)
                .filter(guard -> !obstacles.contains(getNextPosition(guard)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot move from this position"));   
        }

        return move(current);
    }

    /**
     * Move the lab guard a step forward in the direction they are facing.
     * 
     * @param labGuard The lab guard to move.
     * 
     * @return The lab guard after they have moved.
     */
    private LabGuard move(LabGuard labGuard) {

        return ImmutableLabGuard.copyOf(labGuard)
            .withPosition(getNextPosition(labGuard));
    }

    /**
     * Turn the lab guard 90° clockwise if faced with an obstacle directly ahead.
     * 
     * @param labGuard The lab guard to turn.
     * 
     * @return The lab guard after they have turned.
     */
    private LabGuard turn(LabGuard labGuard) {

        return ImmutableLabGuard.copyOf(labGuard)
            .withFacing(switch (labGuard.getFacing()) {
                case UP -> Direction.RIGHT;
                case RIGHT -> Direction.DOWN;
                case DOWN -> Direction.LEFT;
                case LEFT -> Direction.UP;
            });
    }

    /**
     * Retrieve the CoordinatePair of the position directly ahead of the lab guard.
     * 
     * @param labGuard The lab guard.
     * 
     * @return The CoordinatePair of the position directly ahead of the lab guard.
     */
    private CoordinatePair getNextPosition(LabGuard labGuard) {

        return switch (labGuard.getFacing()) {
            case UP -> CoordinatePair.of(labGuard.getPosition().getXCoordinate(), labGuard.getPosition().getYCoordinate() - 1);
            case RIGHT -> CoordinatePair.of(labGuard.getPosition().getXCoordinate() + 1, labGuard.getPosition().getYCoordinate());
            case DOWN -> CoordinatePair.of(labGuard.getPosition().getXCoordinate(), labGuard.getPosition().getYCoordinate() + 1);
            case LEFT -> CoordinatePair.of(labGuard.getPosition().getXCoordinate() - 1, labGuard.getPosition().getYCoordinate());
        };
    }
}
