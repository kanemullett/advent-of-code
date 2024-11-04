package challenges.aoc2023.day2.function;

import challenges.aoc2023.day2.model.BagGame;
import challenges.aoc2023.day2.model.type.CubeColour;
import challenges.aoc2023.day2.util.BagGameUtils;

import java.util.function.ToIntFunction;

/**
 * Function class to determine the power value of a bag game.
 */
public class PowerDeterminerFunction implements ToIntFunction<BagGame> {

    /**
     * Apply function logic to determine the power value of a bag game.
     *
     * @param bagGame the bag game whose power value is to be calculated.
     *
     * @return The power value of the bag game.
     */
    @Override
    public int applyAsInt(BagGame bagGame) {

        return BagGameUtils.getMaximumShownForColour(bagGame, CubeColour.RED)
            * BagGameUtils.getMaximumShownForColour(bagGame, CubeColour.GREEN)
            * BagGameUtils.getMaximumShownForColour(bagGame, CubeColour.BLUE);
    }
}
