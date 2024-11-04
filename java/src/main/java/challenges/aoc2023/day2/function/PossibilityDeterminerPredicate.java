package challenges.aoc2023.day2.function;

import challenges.aoc2023.day2.model.BagGame;
import challenges.aoc2023.day2.model.type.CubeColour;

import java.util.function.Predicate;

import static challenges.aoc2023.day2.util.BagGameUtils.getMaximumShownForColour;

/**
 * Predicate class to determine whether a game is possible, given a stated maximum number of each colour.
 */
public class PossibilityDeterminerPredicate implements Predicate<BagGame> {
    private final Integer totalReds;
    private final Integer totalGreens;
    private final Integer totalBlues;

    /**
     * Predicate class to determine whether a game is possible, given a stated maximum number of each colour.
     *
     * @param totalReds the maximum number of red cubes.
     * @param totalGreens the maximum number of green cubes.
     * @param totalBlues the maximum number of blue cubes.
     */
    public PossibilityDeterminerPredicate(Integer totalReds, Integer totalGreens, Integer totalBlues) {
        this.totalReds = totalReds;
        this.totalGreens = totalGreens;
        this.totalBlues = totalBlues;
    }

    /**
     * Apply predicate logic to determine whether a game is possible.
     *
     * @param bagGame the bag game to check.
     *
     * @return True if the game is possible, false otherwise.
     */
    @Override
    public boolean test(BagGame bagGame) {
        return getMaximumShownForColour(bagGame, CubeColour.RED) <= totalReds
            && getMaximumShownForColour(bagGame, CubeColour.GREEN) <= totalGreens
            && getMaximumShownForColour(bagGame, CubeColour.BLUE) <= totalBlues;
    }
}
