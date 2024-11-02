package challenges.aoc2023.day1.model;

import org.immutables.value.Value.Immutable;

@Immutable
public interface ValuePosition {

    String getValue();

    Integer getPosition();

    static ValuePosition of(String value, Integer position) {
        return ImmutableValuePosition.builder()
               .value(value)
               .position(position)
               .build();
    }
}
