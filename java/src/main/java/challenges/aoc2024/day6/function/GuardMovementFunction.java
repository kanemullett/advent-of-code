package challenges.aoc2024.day6.function;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import challenges.aoc2024.day6.model.ImmutableLabGuard;
import challenges.aoc2024.day6.model.LabGuard;
import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

public class GuardMovementFunction implements UnaryOperator<LabGuard> {
    private final List<CoordinatePair> obstacles;
    
    public GuardMovementFunction(List<CoordinatePair> obstacles) {
        this.obstacles = obstacles;
    }

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

    private LabGuard move(LabGuard labGuard) {

        return ImmutableLabGuard.copyOf(labGuard)
            .withPosition(getNextPosition(labGuard));
    }

    private LabGuard turn(LabGuard labGuard) {

        return ImmutableLabGuard.copyOf(labGuard)
            .withFacing(switch (labGuard.getFacing()) {
                case UP -> Direction.RIGHT;
                case RIGHT -> Direction.DOWN;
                case DOWN -> Direction.LEFT;
                case LEFT -> Direction.UP;
            });
    }

    private CoordinatePair getNextPosition(LabGuard labGuard) {

        return switch (labGuard.getFacing()) {
            case UP -> CoordinatePair.of(labGuard.getPosition().getXCoordinate(), labGuard.getPosition().getYCoordinate() - 1);
            case RIGHT -> CoordinatePair.of(labGuard.getPosition().getXCoordinate() + 1, labGuard.getPosition().getYCoordinate());
            case DOWN -> CoordinatePair.of(labGuard.getPosition().getXCoordinate(), labGuard.getPosition().getYCoordinate() + 1);
            case LEFT -> CoordinatePair.of(labGuard.getPosition().getXCoordinate() - 1, labGuard.getPosition().getYCoordinate());
        };
    }
}
