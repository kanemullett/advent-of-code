package challenges.aoc2023.day2.util;

import challenges.aoc2023.day2.model.BagGame;
import challenges.aoc2023.day2.model.type.CubeColour;

/**
 * Utility class for BagGame related operations.
 */
public class BagGameUtils {

    private BagGameUtils() {
        // Prevent instantiation of utility class
    }

    /**
     * Determine the maximum number of cubes shown for a given colour in a given BagGame.
     *
     * @param game The BagGame to analyse.
     * @param colour The colour for which to find the maximum shown cubes.
     *
     * @return The maximum number of cubes shown for the given colour in the BagGame.
     */
    public static Integer getMaximumShownForColour(BagGame game, CubeColour colour) {
        return game.getReveals().stream()
            .mapToInt(cubeReveal -> cubeReveal.getNumberOfCubesByColour(colour))
            .max()
            .orElseThrow();
    }
}
