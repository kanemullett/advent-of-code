package challenges.aoc2024.day6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import challenges.aoc2024.day6.function.GuardMovementFunction;
import challenges.aoc2024.day6.model.ImmutableLabMap;
import challenges.aoc2024.day6.model.LabGuard;
import challenges.aoc2024.day6.model.LabMap;
import model.CoordinatePair;

/**
 * Service for simulating the lab guard's patrols.
 */
public class LabService {
    
    public LabService() {
        // Empty constructor for dependency injection
    }

    /**
     * Count the number of unique positions the guard visits along their patrol.
     * 
     * @param labMap The map of the lab.
     * 
     * @return The number of unique positions visited.
     */
    public Integer countNumberOfUniquePositionsGuardVisits(LabMap labMap) {
        
        return getUniquePositionsGuardVisits(labMap).size();
    }
    
    /**
     * Count the number of positions in which a single obstruction can be placed with the intended purpose of forcing the lab guard into
     * an infinite loop.
     * 
     * @param labMap The map of the lab.
     * 
     * @return The number of obstruction placement positions.
     */
    public Integer countObstructionPlacementPositions(LabMap labMap) {

        return getUniquePositionsGuardVisits(labMap).stream()
            .filter(position -> isValidObstructionLocation(labMap, position))
            .toList().size();
    }

    /**
     * Get the unique positions the guard visit along their patrol.
     * 
     * @param labMap The map of the lab.
     * 
     * @return The unique positions visited.
     */
    private List<CoordinatePair> getUniquePositionsGuardVisits(LabMap labMap) {

        return Stream.iterate(labMap.getGuard(), new GuardMovementFunction(labMap.getObstacles()))
            .map(LabGuard::getPosition)
            .takeWhile(position -> inLab(position, labMap))
            .distinct()
            .toList();
    }

    /**
     * Evaluate whether an obstruction being placed in the provided position would send the lab guard into an infinite loop.
     * 
     * @param labMap The map of the lab.
     * @param obstructionLocation The position at which to place the obstruction.
     * 
     * @return True if the obstruction sends the lab guard into an infinite loop.
     */
    private boolean isValidObstructionLocation(LabMap labMap, CoordinatePair obstructionLocation) {
        final List<CoordinatePair> obstacles = new ArrayList<>(labMap.getObstacles());

        if (obstacles.contains(obstructionLocation)) {
            return false;
        }
        obstacles.add(obstructionLocation);

        final LabMap updated = ImmutableLabMap.copyOf(labMap)
            .withObstacles(obstacles);

        final List<String> guardInstances = new ArrayList<>();

        final List<LabGuard> labGuardExits = Stream.iterate(updated.getGuard(), new GuardMovementFunction(updated.getObstacles()))
            .takeWhile(guard -> {
                final String guardKey = getGuardKey(guard);

                if (guardInstances.contains(guardKey)) {
                    return false;
                }

                guardInstances.add(guardKey);

                return inLab(guard.getPosition(), updated);
            })
            .toList();

        // guardInstances.size() would be larger if loop-break was due to being out-of-lab.
        return labGuardExits.size() == guardInstances.size();
    }

    /**
     * Create a guard key string by joining the position of the lab guard with the direction they are facing.
     * 
     * @param guard The lab guard.
     * 
     * @return The guard key.
     */
    private String getGuardKey(LabGuard guard) {
        return String.format("%s_%s", guard.getPosition().toString(), guard.getFacing().toString());
    }

    /**
     * Evaluate whether a position is still within the confines of the lab.
     * 
     * @param position The position to check.
     * @param labMap The map of the lab.
     * 
     * @return True if the position is in the lab.
     */
    private boolean inLab(CoordinatePair position, LabMap labMap) {

        return position.getXCoordinate() >= 0
            && position.getXCoordinate() < labMap.getWidth()
            && position.getYCoordinate() >= 0
            && position.getYCoordinate() < labMap.getHeight();
    }
}
