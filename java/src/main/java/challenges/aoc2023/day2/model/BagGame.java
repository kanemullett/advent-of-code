package challenges.aoc2023.day2.model;

import org.immutables.value.Value.Immutable;

import java.util.Arrays;
import java.util.List;

/**
 * Object to represent a single iteration of the game in which cubes are pulled from the bag.
 */
@Immutable
public interface BagGame {

    /**
     * The id of the game iteration. This is equal to the nth game iteration.
     *
     * @return The id of the game iteration.
     */
    Integer getId();

    /**
     * The reveals made during the game iteration. A single reveal is made when a set of cubes are pulled from the bag.
     *
     * @return The list of reveals made during the game iteration.
     */
    List<CubeReveal> getReveals();

    /**
     * Build a BagGame object from the given game string.
     *
     * @param gameString The game string provided by the Advent of Code puzzle input.
     *
     * @return BagGame object.
     */
    static BagGame of(String gameString) {
        final String[] gameStringParts = gameString.split(": ");

        final List<CubeReveal> reveals = Arrays.stream(gameStringParts[1].split("; "))
            .map(CubeReveal::of)
            .toList();

        return ImmutableBagGame.builder()
            .id(Integer.parseInt(gameStringParts[0].split(" ")[1]))
            .reveals(reveals)
            .build();
    }

    /**
     * Build a BagGame object with the given id and reveals.
     *
     * @param id The id of the game iteration.
     * @param reveals The list of reveals made during the game iteration.
     *
     * @return BagGame object.
     */
    static BagGame of(Integer id, List<CubeReveal> reveals) {
        return ImmutableBagGame.builder()
           .id(id)
           .reveals(reveals)
           .build();
    }
}
