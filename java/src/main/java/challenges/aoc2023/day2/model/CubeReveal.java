package challenges.aoc2023.day2.model;

import challenges.aoc2023.day2.model.type.CubeColour;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

import java.util.Arrays;

/**
 * Object to represent a cube reveal in the game. A cube reveal can be defined as an instance in which a set of cubes
 * are pulled from the game bag.
 */
@Immutable
public interface CubeReveal {

    /**
     * The number of red cubes in the cube reveal.
     *
     * @return The number of red cubes.
     */
    @Default
    default Integer getRed() {
        return 0;
    }

    /**
     * The number of green cubes in the cube reveal.
     *
     * @return The number of green cubes.
     */
    @Default
    default Integer getGreen() {
        return 0;
    }

    /**
     * The number of blue cubes in the cube reveal.
     *
     * @return The number of blue cubes.
     */
    @Default
    default Integer getBlue() {
        return 0;
    }

    /**
     * Retrieve the number of cubes of a specific colour in the cube reveal.
     *
     * @param colour The colour whose cube count is to be returned.
     *
     * @return The number of cubes of the specified colour.
     */
    default Integer getNumberOfCubesByColour(CubeColour colour) {
        return switch (colour) {
            case RED -> getRed();
            case GREEN -> getGreen();
            case BLUE -> getBlue();
        };
    }

    /**
     * Build a CubeReveal object from its string representation within the input string.
     *
     * @param revealString The string representation of the cube reveal.
     *
     * @return CubeReveal object.
     */
    static CubeReveal of(String revealString) {
        final String[] split = revealString.split(", ");

        return ImmutableCubeReveal.builder()
            .red(getNumberOfColour(split, "red"))
            .green(getNumberOfColour(split, "green"))
            .blue(getNumberOfColour(split, "blue"))
            .build();
    }

    /**
     * Build a CubeReveal object from the number of red, green, and blue cubes pulled from the bag.
     *
     * @param red The number of red cubes.
     * @param green The number of green cubes.
     * @param blue The number of blue cubes.
     *
     * @return CubeReveal object.
     */
    static CubeReveal of(Integer red, Integer green, Integer blue) {
        return ImmutableCubeReveal.builder()
           .red(red)
           .green(green)
           .blue(blue)
           .build();
    }

    /**
     * Retrieve the number of cubes of a specific colour in the cube reveal.
     *
     * @param colourParts The parts of the cube reveal string pertaining to each colour.
     * @param colour The colour whose cube count is to be returned.
     *
     * @return The number of cubes of the specified colour.
     */
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
