package challenges.aoc2024.day8.function;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import challenges.aoc2024.day8.model.CityMap;
import model.CoordinatePair;

/**
 * Function class for plotting antinode locations.
 */
public class AntinodePlottingFunction implements UnaryOperator<List<CoordinatePair>> {
    private final CityMap cityMap;
    private final boolean applyResonantHarmonics;

    /**
     * Function class for plotting antinode locations.
     * 
     * @param cityMap The map of the city.
     * @param applyResonantHarmonics True if resonant harmonics should be applied.
     */
    public AntinodePlottingFunction(CityMap cityMap, boolean applyResonantHarmonics) {
        this.cityMap = cityMap;
        this.applyResonantHarmonics = applyResonantHarmonics;
    }
    
    /**
     * Apply function logic to plot antinodes.
     * 
     * @param antennaPositions The positions of the antennas.
     * 
     * @return The locations of the plotted antinodes.
     */
    @Override
    public List<CoordinatePair> apply(List<CoordinatePair> antennaPositions) {

        return antennaPositions.stream()
            .flatMap(position -> antennaPositions.stream()
                .filter(subposition -> !subposition.equals(position))
                .flatMap(subposition -> plotAntinodes(position, subposition).stream()))
            .distinct()
            .filter(this::inCity)
            .toList();
    }

    /**
     * Determine whether an antinode is within the bounds of the city.
     * 
     * @param position The position of the antinode.
     * 
     * @return True if the antinode is within the city.
     */
    private boolean inCity(CoordinatePair position) {

        return position.getXCoordinate() >= 0
            && position.getXCoordinate() < cityMap.getWidth()
            && position.getYCoordinate() >= 0
            && position.getYCoordinate() < cityMap.getHeight();
    }

    /**
     * Plot antinodes within the city.
     * 
     * @param firstAntennaPosition The position of the first antenna.
     * @param secondAntennaPosition The position of the second antenna.
     * 
     * @return The positions of the plotted antinodes.
     */
    private List<CoordinatePair> plotAntinodes(CoordinatePair firstAntennaPosition, CoordinatePair secondAntennaPosition) {
        final CoordinatePair movementVector = CoordinatePair.of(firstAntennaPosition.getXCoordinate() - secondAntennaPosition.getXCoordinate(), firstAntennaPosition.getYCoordinate() - secondAntennaPosition.getYCoordinate());

        if (applyResonantHarmonics) {
            final CoordinatePair moveFrom = getClosestAntinodeToLeftEdge(firstAntennaPosition, movementVector);

            return plotAllAntinodesFromPositionWithMovementVector(moveFrom, movementVector);
        }

        return List.of(
            CoordinatePair.of(firstAntennaPosition.getXCoordinate() + movementVector.getXCoordinate(), firstAntennaPosition.getYCoordinate() + movementVector.getYCoordinate()),
            CoordinatePair.of(secondAntennaPosition.getXCoordinate() - movementVector.getXCoordinate(), secondAntennaPosition.getYCoordinate() - movementVector.getYCoordinate())
        );
    }

    /**
     * Get the location of the closest point to the left edge of the city that sits in line with the antennas.
     * 
     * @param antennaPosition The position of one of the antennas.
     * @param movementVector The movement vector that plots points in line with the antennas.
     * 
     * @return The closest point on the line to the left edge.
     */
    private CoordinatePair getClosestAntinodeToLeftEdge(CoordinatePair antennaPosition, CoordinatePair movementVector) {
        
        if (antennaPosition.getXCoordinate() == 0) {
            return antennaPosition;
        }
        
        Stream<CoordinatePair> coordinates;

        if (movementVector.getXCoordinate() > 0) {
            coordinates = Stream.iterate(antennaPosition, position -> CoordinatePair.of(position.getXCoordinate() - movementVector.getXCoordinate(), position.getYCoordinate() - movementVector.getYCoordinate()))
                .takeWhile(coord -> coord.getXCoordinate() >= 0);
        } else {
            coordinates = Stream.iterate(antennaPosition, position -> CoordinatePair.of(position.getXCoordinate() + movementVector.getXCoordinate(), position.getYCoordinate() + movementVector.getYCoordinate()))
                .takeWhile(coord -> coord.getXCoordinate() >= 0);
        }

        return coordinates
            .sorted((coord1, coord2) -> Integer.compare(coord1.getXCoordinate(), coord2.getXCoordinate()))
            .toList().get(0);
    }

    /**
     * Plot all the antinodes in line with the two antennas using their shared movement vector and the first position on the line.
     * 
     * @param moveFrom The first point on the line.
     * @param movementVector The movement vector to apply.
     * 
     * @return List of antinode positions.
     */
    private List<CoordinatePair> plotAllAntinodesFromPositionWithMovementVector(CoordinatePair moveFrom, CoordinatePair movementVector) {

        Stream<CoordinatePair> coordinatesVisited;

        if (movementVector.getXCoordinate() > 0) {
            coordinatesVisited = Stream.iterate(moveFrom, position -> CoordinatePair.of(position.getXCoordinate() + movementVector.getXCoordinate(), position.getYCoordinate() + movementVector.getYCoordinate()))
                .takeWhile(coord -> coord.getXCoordinate() < cityMap.getWidth());
        } else {
            coordinatesVisited = Stream.iterate(moveFrom, position -> CoordinatePair.of(position.getXCoordinate() - movementVector.getXCoordinate(), position.getYCoordinate() - movementVector.getYCoordinate()))
                .takeWhile(coord -> coord.getXCoordinate() < cityMap.getWidth());
        }

        return coordinatesVisited.toList();
    }
}
