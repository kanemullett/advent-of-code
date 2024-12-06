package challenges.aoc2024.day6.model;

import java.util.List;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

/**
 * LabMap object containing all information pertaining to the initial layout of the lab.
 */
@Immutable
public interface LabMap {

    /**
     * The height of the lab.
     * 
     * @return The height of the lab.
     */
    Integer getHeight();

    /**
     * The width of the lab.
     * 
     * @return The width of the lab.
     */
    Integer getWidth();

    /**
     * The lab guard patrolling the lab.
     * 
     * @return The lab guard.
     */
    LabGuard getGuard();
    
    /**
     * The obstacles blocking the lab guard's path.
     * 
     * @return The positions of the obstacles.
     */
    List<CoordinatePair> getObstacles();

    /**
     * Build a LabMap object from the map rows.
     * 
     * @param mapRows The map row strings.
     * 
     * @return The LabMap object.
     */
    static LabMap of(List<String> mapRows) {

        return ImmutableLabMap.builder()
            .height(mapRows.size())
            .width(mapRows.get(0).length())
            .guard(IntStream.range(0, mapRows.size())
                .mapToObj(i -> IntStream.range(0, mapRows.get(i).split("").length)
                    .filter(colIndex -> List.of("^", ">", "v", "<").contains(mapRows.get(i).split("")[colIndex]))
                    .mapToObj(arrowColIndex -> LabGuard.of(Direction.of(mapRows.get(i).split("")[arrowColIndex]), CoordinatePair.of(arrowColIndex, i)))
                    .toList())
                .flatMap(List::stream)
                .toList()
                .get(0))
            .obstacles(IntStream.range(0, mapRows.size())
                .mapToObj(i -> IntStream.range(0, mapRows.get(i).split("").length)
                    .filter(colIndex -> "#".equals(mapRows.get(i).split("")[colIndex]))
                    .mapToObj(hashColIndex -> CoordinatePair.of(hashColIndex, i))
                    .toList())
                .flatMap(List::stream)
                .toList())
            .build();
    }
}
