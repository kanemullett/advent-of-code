package challenges.aoc2024.day1.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.immutables.value.Value.Immutable;

@Immutable
public interface LocationList {
    
    List<ListLinePair> getLinePairs();

    static LocationList of(List<String> unorderdListPairStrings) {
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

        return ImmutableLocationList.builder()
                .linePairs(IntStream.range(0, leftList.size())
                    .mapToObj(i -> ListLinePair.of(leftList.get(i), rightList.get(i)))
                    .collect(Collectors.toList()))
                .build();
    }
}
