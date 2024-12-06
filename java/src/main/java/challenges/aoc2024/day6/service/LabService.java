package challenges.aoc2024.day6.service;

import java.util.List;
import java.util.stream.Stream;

import challenges.aoc2024.day6.function.GuardMovementFunction;
import challenges.aoc2024.day6.model.LabGuard;
import challenges.aoc2024.day6.model.LabMap;
import model.CoordinatePair;

public class LabService {
    
    public LabService() {
        // Empty constructor for dependency injection
    }

    public Integer countNumberOfUniquePositionsGuardVisits(LabMap labMap) {
        final LabGuard guard = labMap.getGuard();
        final List<CoordinatePair> obstacles = labMap.getObstacles();
        
        return Stream.iterate(guard, new GuardMovementFunction(obstacles))
            .map(LabGuard::getPosition)
            .takeWhile(position -> inLab(position, labMap))
            .distinct()
            .toList().size();
    }

    private boolean inLab(CoordinatePair position, LabMap labMap) {

        return position.getXCoordinate() >= 0
            && position.getXCoordinate() < labMap.getWidth()
            && position.getYCoordinate() >= 0
            && position.getYCoordinate() < labMap.getHeight();
    }
}
