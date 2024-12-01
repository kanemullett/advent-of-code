package challenges.aoc2024.day1.model;

import org.immutables.value.Value.Immutable;

@Immutable
public interface ListLinePair {
    
    Integer getLeftValue();

    Integer getRightValue();

    static ListLinePair of(Integer leftValue, Integer rightValue) {
        return ImmutableListLinePair.builder()
                .leftValue(leftValue)
                .rightValue(rightValue)
                .build();
    }

}
