package challenges.aoc2023.day2.service;

import challenges.aoc2023.day2.function.PossibilityDeterminerPredicate;
import challenges.aoc2023.day2.function.PowerDeterminerFunction;
import challenges.aoc2023.day2.model.BagGame;

import java.util.List;

/**
 * Service for performing operations with regard to the outcomes of bag games.
 */
public class BagGameService {

    /**
     * Calculate the total of the IDs of bag games that would be possible, provided that the maximum number of balls
     * inserted into the bag are as follows:
     * <ul>
     *     <li>Red cubes: 12</li>
     *     <li>Green cubes: 13</li>
     *     <li>Blue cubes: 14</li>
     * </ul>
     *
     * @param bagGames The bag games whose possibility is to be determined.
     *
     * @return The total of the IDs of bag games that would be possible.
     */
    public String calculateTotalOfPossibleIds(List<BagGame> bagGames) {

        return String.valueOf(bagGames.stream()
            .filter(new PossibilityDeterminerPredicate(12, 13, 14))
            .mapToInt(BagGame::getId)
            .sum());
    }

    /**
     * Calculate the total of the cube powers of bag games. A cube power is defined as:
     * <code>lowestPossibleReds * lowestPossibleGreens * lowestPossibleBlues</code>
     *
     * @param bagGames The bag games whose cube powers are to be calculated.
     *
     * @return The total of the cube powers of bag games.
     */
    public String calculateTotalOfCubePowers(List<BagGame> bagGames) {

        return String.valueOf(bagGames.stream()
            .mapToInt(new PowerDeterminerFunction())
            .sum());
    }
}
