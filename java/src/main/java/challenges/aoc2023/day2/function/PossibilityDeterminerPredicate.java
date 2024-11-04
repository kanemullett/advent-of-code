package challenges.aoc2023.day2.function;

import challenges.aoc2023.day2.model.BagGame;
import challenges.aoc2023.day2.model.BallReveal;
import challenges.aoc2023.day2.model.type.BallColour;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PossibilityDeterminerPredicate implements Predicate<BagGame> {
    private final Integer totalReds;
    private final Integer totalGreens;
    private final Integer totalBlues;

    public PossibilityDeterminerPredicate(Integer totalReds, Integer totalGreens, Integer totalBlues) {
        this.totalReds = totalReds;
        this.totalGreens = totalGreens;
        this.totalBlues = totalBlues;
    }

    @Override
    public boolean test(BagGame bagGame) {
        return getMaximumShownForColour(bagGame, BallColour.RED) <= totalReds
            && getMaximumShownForColour(bagGame, BallColour.GREEN) <= totalGreens
            && getMaximumShownForColour(bagGame, BallColour.BLUE) <= totalBlues;
    }

    private Integer getMaximumShownForColour(BagGame game, BallColour colour) {
        Integer hello = game.getReveals().stream()
            .mapToInt(ballReveal -> ballReveal.getNumberOfBallsByColour(colour))
            .max()
            .orElseThrow();

        return game.getReveals().stream()
            .mapToInt(ballReveal -> ballReveal.getNumberOfBallsByColour(colour))
            .max()
            .orElseThrow();
    }
}
