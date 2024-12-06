package challenges.aoc2024.day6.model;

import java.util.List;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

import challenges.aoc2024.day6.model.type.Direction;
import model.CoordinatePair;

@Immutable
public interface LabMap {

    Integer getHeight();

    Integer getWidth();

    LabGuard getGuard();
    
    List<CoordinatePair> getObstacles();

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
