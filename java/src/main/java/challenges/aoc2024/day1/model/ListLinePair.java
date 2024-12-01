package challenges.aoc2024.day1.model;

import org.immutables.value.Value.Immutable;

/**
 * ListLinePair object containing the two values to be compared on each line of the two location lists.
 */
@Immutable
public interface ListLinePair {
    
    /**
     * The left list's value.
     * 
     * @return The left value.
     */
    Integer getLeftValue();

    /**
     * The right list's value.
     * 
     * @return The right value.
     */
    Integer getRightValue();

    /**
     * Build a ListLinePair object from the given left and right values.
     * 
     * @param leftValue The left list's value.
     * @param rightValue The right list's value.
     * 
     * @return ListLinePair object.
     */
    static ListLinePair of(Integer leftValue, Integer rightValue) {
        return ImmutableListLinePair.builder()
                .leftValue(leftValue)
                .rightValue(rightValue)
                .build();
    }

}
