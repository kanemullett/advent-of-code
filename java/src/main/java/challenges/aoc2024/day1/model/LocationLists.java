package challenges.aoc2024.day1.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

/**
 * LocationLists object containing the two location lists.
 */
@Immutable
public interface LocationLists {
    
    /**
     * The pairs of values on each line from both location lists.
     * 
     * @return List of line value pairs.
     */
    List<ListLinePair> getLinePairs();

    /**
     * Build a LocationLists object from the given unordered list pair strings.
     * 
     * @param unorderdListPairStrings List of unordered list pair strings.
     * 
     * @return LocationLists object.
    */
    static LocationLists of(List<String> unorderdListPairStrings) {
        final List<Integer> leftList = unorderdListPairStrings.stream()
            .map(pairString -> pairString.split(" {3}")[0])
            .map(Integer::parseInt)
            .sorted()
            .toList();

        final List<Integer> rightList = unorderdListPairStrings.stream()
            .map(pairString -> pairString.split(" {3}")[1])
            .map(Integer::parseInt)
            .sorted()
            .toList();

        return ImmutableLocationLists.builder()
                .linePairs(IntStream.range(0, leftList.size())
                    .mapToObj(i -> ListLinePair.of(leftList.get(i), rightList.get(i)))
                    .collect(Collectors.toList()))
                .build();
    }
}
