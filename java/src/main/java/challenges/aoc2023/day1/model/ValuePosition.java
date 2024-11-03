package challenges.aoc2023.day1.model;

import org.immutables.value.Value.Immutable;

/**
 * ValuePosition object representing a value and its position in a string.
 */
@Immutable
public interface ValuePosition {

    /**
     * The value within the string.
     *
     * @return The value.
     */
    String getValue();

    /**
     * The position of the value within the string.
     *
     * @return The position.
     */
    Integer getPosition();

    /**
     * Build a ValuePosition object from a value and its position within a string.
     *
     * @param value The value within the string.
     * @param position The position of the value within the string.
     *
     * @return The ValuePosition object.
     */
    static ValuePosition of(String value, Integer position) {
        return ImmutableValuePosition.builder()
               .value(value)
               .position(position)
               .build();
    }
}
