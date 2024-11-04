package challenges.aoc2023.day2.service;

import challenges.aoc2023.day2.function.PossibilityDeterminerPredicate;
import challenges.aoc2023.day2.model.BagGame;

import java.util.List;

public class BagGameService {
    public String calculateTotalOfPossibleIds(List<BagGame> bagGames) {

        return String.valueOf(bagGames.stream()
            .filter(new PossibilityDeterminerPredicate(12, 13, 14))
            .mapToInt(BagGame::getId)
            .sum());
    }
}
