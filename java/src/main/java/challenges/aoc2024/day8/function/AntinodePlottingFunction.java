package challenges.aoc2024.day8.function;

import java.util.List;
import java.util.function.UnaryOperator;

import model.CoordinatePair;

public class AntinodePlottingFunction implements UnaryOperator<List<CoordinatePair>> {
    private final Integer cityHeight;
    private final Integer cityWidth;

    public AntinodePlottingFunction(Integer cityHeight, Integer cityWidth) {
        this.cityHeight = cityHeight;
        this.cityWidth = cityWidth;
    }
    
    @Override
    public List<CoordinatePair> apply(List<CoordinatePair> antennaPositions) {

        return antennaPositions.stream()
            .map(position -> antennaPositions.stream()
                .filter(subposition -> !subposition.equals(position))
                .map(subposition -> plotAntinodes(position, subposition))
                .flatMap(List::stream)
                .toList())
            .flatMap(List::stream)
            .distinct()
            .filter(this::inCity)
            .toList();
    }

    private boolean inCity(CoordinatePair position) {

        return position.getXCoordinate() >= 0
            && position.getXCoordinate() < cityWidth
            && position.getYCoordinate() >= 0
            && position.getYCoordinate() < cityHeight;
    }

    private List<CoordinatePair> plotAntinodes(CoordinatePair firstAntennaPosition, CoordinatePair secondAntennaPosition) {
        final Integer distanceX = firstAntennaPosition.getXCoordinate() - secondAntennaPosition.getXCoordinate();
        final Integer distanceY = firstAntennaPosition.getYCoordinate() - secondAntennaPosition.getYCoordinate();

        return List.of(
            CoordinatePair.of(firstAntennaPosition.getXCoordinate() + distanceX, firstAntennaPosition.getYCoordinate() + distanceY),
            CoordinatePair.of(secondAntennaPosition.getXCoordinate() - distanceX, secondAntennaPosition.getYCoordinate() - distanceY)
        );
    }
}
