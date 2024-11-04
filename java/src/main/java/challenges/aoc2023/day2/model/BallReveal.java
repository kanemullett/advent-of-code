package challenges.aoc2023.day2.model;

import challenges.aoc2023.day2.model.type.BallColour;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

import java.util.Arrays;

@Immutable
public interface BallReveal {
    @Default
    default Integer getRed() {
        return 0;
    }

    @Default
    default Integer getGreen() {
        return 0;
    }

    @Default
    default Integer getBlue() {
        return 0;
    }

    default Integer getNumberOfBallsByColour(BallColour colour) {
        return switch (colour) {
            case RED -> getRed();
            case GREEN -> getGreen();
            case BLUE -> getBlue();
        };
    }

    static BallReveal of(String revealString) {
        final String[] split = revealString.split(", ");

        return ImmutableBallReveal.builder()
            .red(getNumberOfColour(split, "red"))
            .green(getNumberOfColour(split, "green"))
            .blue(getNumberOfColour(split, "blue"))
            .build();
    }

    static BallReveal of(Integer red, Integer green, Integer blue) {
        return ImmutableBallReveal.builder()
           .red(red)
           .green(green)
           .blue(blue)
           .build();
    }

    private static Integer getNumberOfColour(String[] colourParts, String colour) {
        final String colourPart = Arrays.stream(colourParts)
            .filter(part -> part.contains(colour))
            .findFirst()
            .orElse(null);

        if (colourPart == null) {
            return 0;
        }

        return Integer.parseInt(colourPart.split(" ")[0]);
    }
}
